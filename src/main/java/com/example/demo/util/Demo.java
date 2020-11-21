package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Demo 类是
 *
 * @author dongyinggang
 * @date 2020-11-18 13:33
 **/
@Slf4j
public class Demo {
    public static void main(String[] args) {
//        任务列表
        List<Integer> jobList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        int nThreads = 3;
//        工作线程池
        ExecutorService executorService = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
//        接收每个任务的执行结果
        List<CompletableFuture<String>> completableFutures = new ArrayList<>(jobList.size());

//        任务分派
        for (int i = 0; i < jobList.size(); i++) {

            try {
                Integer jobId = jobList.get(i);

                CompletableFuture<String> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {

                    log.info("模拟任务执行，执行任务：{}", jobId);
//                    睡几秒
                    return jobId + "任务执行结果";
                }, executorService);
//            保存本次任务执行结果
                completableFutures.add(integerCompletableFuture);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

        }

        log.info("任务分派结束");

//        等待全部任务执行完毕
        CompletableFuture[] completableFutures1 = new CompletableFuture[completableFutures.size()];
        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.allOf(completableFutures.toArray(completableFutures1));
        try {
            voidCompletableFuture.get();
            log.info("打印执行结果");
            completableFutures.stream()
                    .forEach(tmp -> {
                        try {
                            log.info("执行结果：{}", tmp.get());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        log.info("任务执行完毕");

    }
}

