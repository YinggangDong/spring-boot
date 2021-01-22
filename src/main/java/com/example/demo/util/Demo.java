package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demo 类是 CompletableFuture的demo测试
 *
 * @author dongyinggang
 * @date 2020-11-18 13:33
 **/
@Slf4j
public class Demo {

    public static void test() {
        long start = System.currentTimeMillis();
        log.info("任务执行开始");
        AtomicInteger counter = new AtomicInteger(1);
//        任务列表
        List<Integer> jobList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        int nThreads = 3;
//        工作线程池
        ExecutorService executorService = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), (r) -> new Thread(r, "t-" + counter.getAndIncrement()));
//        接收每个任务的执行结果
        List<CompletableFuture<String>> completableFutures = new ArrayList<>(jobList.size());

//        任务分派
        for (Integer jobId : jobList) {
            try {

                CompletableFuture<String> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {

                    log.info("模拟任务执行，执行任务：{}", jobId);
//                    睡几秒
                    return "任务"+jobId + "任务执行成功";
                }, executorService);
//            保存本次任务执行结果
                completableFutures.add(integerCompletableFuture);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        log.info("任务分派结束");

//        等待全部任务执行完毕
        CompletableFuture[] completableFutures1 = new CompletableFuture[0];
        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.allOf(completableFutures.toArray(completableFutures1));
        try {
            voidCompletableFuture.get();
            log.info("打印执行结果");
            completableFutures.forEach(tmp -> {
                try {
                    log.info("执行结果：{}", tmp.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        voidCompletableFuture.join();
        executorService.shutdown();
        log.info("任务执行完毕,耗时：{}ms",System.currentTimeMillis() - start);

    }

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 finished!");
            return "future1 finished!";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 finished!");
            return "future2 finished!";
        });
        CompletableFuture<Void> combindFuture = CompletableFuture.allOf(future1, future2);
        try {

            combindFuture.join();
            CompletableFuture<String> test = combindFuture.thenApply((r1)-> {
                System.out.println("thenApply方法运行中...");
                return "hello world";
            });
            test.thenAccept(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("future1: " + future1.isDone() + " future2: " + future2.isDone());
    }
}

