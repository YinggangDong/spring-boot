package com.example.demo.util;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * AliOssUtil 类是
 *
 * @author dongyinggang
 * @date 2020-11-11 15:52
 **/
@Slf4j
public class AliOssUtil {
    /**
     * 阿里云API的内或外网域名  //替换成自己的
     */
    private static final String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
    /**
     * 阿里云API的密钥Access Key ID   //替换成自己的
     */
    private static final String ACCESS_KEY_ID = "";
    /**
     * 阿里云API的密钥Access Key Secret   //替换成自己的
     */
    private static final String ACCESS_KEY_SECRET = "";
    /**
     * 阿里云API的bucket名称    //替换成自己的
     */
    private static final String BACKET_NAME = "snbc-smcp";

    /**
     * 批量下载oss 文件 并打成zip 包 返回到response中
     *
     * @param fileNames oss上的文件名集合 如：product/image/3448275920.png
     *                   * @param zipFileName 压缩包文件名
     * @param response  HttpServletResponse
     */
    public static void batchDownLoadOssFile(List<String> fileNames, String zipFileName, HttpServletResponse response) {
        Long start = System.currentTimeMillis();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + zipFileName + ".zip");
        BufferedInputStream bis = null;
        try {
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            for (String fileName : fileNames) {
                Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
                GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(BACKET_NAME, fileName, HttpMethod.GET);
                // 设置过期时间。
                request.setExpiration(expiration);
                // 生成签名URL（HTTP GET请求）。
                URL signedUrl = ossClient.generatePresignedUrl(request);
                // 使用签名URL发送请求。
                OSSObject ossObject = ossClient.getObject(signedUrl, new HashMap<>());
                log.info("{} 下载完成", fileName);
                if (ossObject != null) {
                    InputStream inputStream = ossObject.getObjectContent();
                    byte[] buffs = new byte[1024 * 10];

                    String zipFile = fileName.substring(fileName.lastIndexOf("/") + 1);
                    ZipEntry zipEntry = new ZipEntry(zipFile);
                    zos.putNextEntry(zipEntry);
                    bis = new BufferedInputStream(inputStream, 1024 * 10);

                    int read;
                    while ((read = bis.read(buffs, 0, 1024 * 10)) != -1) {
                        zos.write(buffs, 0, read);
                    }
                    log.info("{}压缩完成", fileName);
                    ossObject.close();
                }
            }
            zos.close();
            Long end = System.currentTimeMillis();
            log.info("批量下载并压缩的耗时：{} ms", (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (null != bis) {
                    bis.close();
                }
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * batchDownLoadOssFileByThreadPool 方法是 通过线程池批量实现OSS服务器文件的批量下载
     *
     * @param fileNames   待下载路径list
     * @param zipFileName 压缩后的文件名
     * @param response    应答
     * @author dongyinggang
     * @date 2020/11/16 10:54
     */
    public static void batchDownLoadOssFileByThreadPool(List<String> fileNames, String zipFileName, HttpServletResponse response) {
        Long start = System.currentTimeMillis();
        if (CollectionUtils.isEmpty(fileNames)) {
            return;
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + zipFileName + ".zip");
        BufferedInputStream bis = null;
        try {
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            ExecutorService executorService = ThreadUtil.buildDownloadBatchThreadPool(10);
            List<CompletableFuture> list = new ArrayList<>();
            for (String fileName : fileNames) {
                //发起请求
                CompletableFuture<OSSObject> cf = CompletableFuture.supplyAsync(
                        () -> getOssObject(ossClient, fileName),
                        executorService);

                list.add(cf);
            }

            CompletableFuture<Void> all = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
            all.thenApply(a -> getZip(list, zos));
            all.join();
            zos.close();
            Long end = System.currentTimeMillis();
            log.info("批量下载并压缩的耗时：{}ms", (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (null != bis) {
                    bis.close();
                }
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static OSSObject getOssObject(OSS ossClient, String fileName) {
        try {
            log.info("开始下载 {}", fileName);
            Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(BACKET_NAME, fileName, HttpMethod.GET);
            // 设置过期时间。
            request.setExpiration(expiration);
            // 生成签名URL（HTTP GET请求）。
            URL signedUrl = ossClient.generatePresignedUrl(request);
            // 使用签名URL发送请求。
            OSSObject ossObject = ossClient.getObject(signedUrl, new HashMap<>());
            ossObject.setKey(fileName);
            log.info("现在结束下载");
            return ossObject;

        } catch (Exception e) {
            log.error("下载异常", e);
        }
        return null;
    }

    private static ZipOutputStream getZip(List<CompletableFuture> ossObjectList, ZipOutputStream zos) {
        Long start = System.currentTimeMillis();
        log.info("开始压缩");
        ossObjectList.forEach(cf -> {
            try {
                OSSObject ossObject = (OSSObject) cf.get();
                InputStream inputStream = ossObject.getObjectContent();
                byte[] buffs = new byte[1024 * 10];
                String fileName = ossObject.getKey();
                String zipFile = fileName.substring(fileName.lastIndexOf("/") + 1);
                ZipEntry zipEntry = new ZipEntry(zipFile);
                //指定当前写入位置
                zos.putNextEntry(zipEntry);
                BufferedInputStream bis = new BufferedInputStream(inputStream, 1024 * 10);

                int read;
                while ((read = bis.read(buffs, 0, 1024 * 10)) != -1) {
                    zos.write(buffs, 0, read);
                }
                bis.close();
                ossObject.close();
            } catch (Exception e) {
                log.error("异常信息", e);
            }

        });
        Long end = System.currentTimeMillis();
        log.info("压缩耗时：" + (end - start) + "ms");
        return zos;
    }
}
