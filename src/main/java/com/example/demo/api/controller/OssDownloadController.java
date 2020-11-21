package com.example.demo.api.controller;

import com.example.demo.util.AliOssUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * OssDownloadController 类是 阿里云存储服务相关
 *
 * @author dongyinggang
 * @date 2020-11-11 15:48
 **/
@RestController
@RequestMapping("test")
public class OssDownloadController {

    @GetMapping(value = "/download")
    public void downloadSource(HttpServletResponse response) {
        List<String> list = new ArrayList<>();
        list.add("workorderpic/20200601/customerService/attachment/2020-06-01/1590988916273.xls");
        list.add("workorderpic/20200601/customerService/attachment/2020-06-01/1590988912932.xlsx");
        list.add("workorderpic/20200813/customerService/attachment/2020-08-13/1597314332426.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597795730861.xlsx");
        list.add("workorderpic/20201015/customerService/attachment/2020-10-15/1602761920004.xlsx");
        list.add("workorderpic/20200915/customerService/attachment/2020-09-15/1600163165005.xlsx");
        list.add("workorderpic/20200818/customerService/attachment/2020-08-18/1597747092552.xlsx");
        list.add("workorderpic/20200919/customerService/attachment/2020-09-19/1600475782401.xlsx");
        list.add("workorderpic/20200706/customerService/attachment/2020-07-06/1594014292555.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597795723625.xlsx");
        list.add("workorderpic/20201019/customerService/attachment/2020-10-19/1603085915824.xlsx");
        list.add("workorderpic/20200818/customerService/attachment/2020-08-18/1597746317698.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597795276950.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597814073204.xlsx");
        list.add("workorderpic/20200813/customerService/attachment/2020-08-13/1597310700900.xlsx");
        list.add("workorderpic/20200818/customerService/attachment/2020-08-18/1597747712284.xlsx");
        list.add("workorderpic/20201111/customerService/attachment/2020-11-11/1605092168659-专项安装导入模板 (2)1.3.1.xlsx");
        list.add("workorderpic/20200706/customerService/attachment/2020-07-06/1594012740012.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597803244565.xlsx");
        list.add("workorderpic/20201012/customerService/attachment/2020-10-12/1602490215083.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597833544535.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597803253954.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597802079531.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597833017221.xlsx");
        list.add("workorderpic/20200915/customerService/attachment/2020-09-15/1600163169376.xlsx");
        list.add("workorderpic/20200818/customerService/attachment/2020-08-18/1597746517166.xlsx");
        list.add("workorderpic/20200812/customerService/attachment/2020-08-12/1597214916709.xlsx");
        list.add("workorderpic/20200813/customerService/attachment/2020-08-13/1597314336645.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597820210208.js");
        list.add("workorderpic/20200818/customerService/attachment/2020-08-18/1597746292910.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597795304139.xlsx");
        list.add("workorderpic/20200601/customerService/attachment/2020-06-01/1590988902924.xlsx");
        list.add("workorderpic/20200915/customerService/attachment/2020-09-15/1600163195331.xlsx");
        list.add("workorderpic/20200706/customerService/attachment/2020-07-06/1594010941364.xlsx");
        list.add("workorderpic/20200915/customerService/attachment/2020-09-15/1600153605692.xlsx");
        list.add("workorderpic/20201019/customerService/attachment/2020-10-19/1603085920669.xlsx");
        list.add("workorderpic/20201110/customerService/attachment/2020-11-10/1604973110339-1.3.0仓储用例.xlsx");
        list.add("workorderpic/20200915/customerService/attachment/2020-09-15/1600153610121.xlsx");
        list.add("workorderpic/20201015/customerService/attachment/2020-10-15/1602761864023.xlsx");
        list.add("workorderpic/20200919/customerService/attachment/2020-09-19/1600475787689.xlsx");
        list.add("workorderpic/20200819/customerService/attachment/2020-08-19/1597820198480.txt");
        String zipFileName = "test";
//        AliOssUtil.batchDownLoadOssFile(list, zipFileName, response);
        AliOssUtil.batchDownLoadOssFileByThreadPool(list,zipFileName,response);

    }
}
