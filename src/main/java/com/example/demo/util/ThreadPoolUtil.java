package com.example.demo.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadPoolUtil 类是 线程池工具类
 *
 * @author dongyinggang
 * @date 2021-01-22 19:11
 **/
public class ThreadPoolUtil {

    /**
     * buildThreadPool 方法是 创建线程池
     *
     * @param prefix          线程名称前缀
     * @param corePoolSize    核心线程数
     * @param maximumPoolSize 最大线程数
     * @param capacity        任务队列长度
     * @return 线程池对象
     * @author dongyinggang
     * @date 2021/1/12 10:52
     */
    public static ExecutorService buildThreadPool(String prefix, int corePoolSize,
                                                  int maximumPoolSize, int capacity) {
        int keepAlive = 0;
        //指定线程，传入线程的名称前缀
        ThreadFactory factory = buildThreadFactory(prefix);
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAlive,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(capacity),
                factory);
    }

    /**
     * 创建自定义线程工厂
     *
     * @param prefix 线程名称前缀
     * @return ThreadFactory
     */
    private static ThreadFactory buildThreadFactory(String prefix) {
        return new CustomThreadFactory(prefix);
    }


    /**
     * 自定义线程工厂
     */
    public static class CustomThreadFactory implements ThreadFactory {
        //线程名称前缀
        private String threadNamePrefix;
        //用来标识这是第几个生成的线程,被拼接在线程名称中
        private AtomicInteger counter = new AtomicInteger(1);

        /**
         * 自定义线程工厂
         *
         * @param threadNamePrefix 线程名称前缀
         */
        CustomThreadFactory(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }

        /**
         * newThread 方法是 创建新线程的方法
         *
         * @param r thread持有的Runnable对象
         * @return 新线程
         * @author dongyinggang
         * @date 2021/1/20 16:37
         */
        @Override
        public Thread newThread(Runnable r) {
            //线程名称=指定前缀-t1(从1到最大线程数)
            String threadName = threadNamePrefix + "-t" + counter.getAndIncrement();
            return new Thread(r, threadName);
        }
    }
}
