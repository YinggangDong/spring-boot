package com.example.demo.config;

import com.example.demo.util.ThreadPoolUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;

/**
 * ThreadPoolConfig 类是 线程池配置
 *
 * @author dongyinggang
 * @date 2021-01-22 19:10
 **/
@Configuration
public class ThreadPoolConfig {

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 10;
    /**
     * 最大线程数
     */
    private static final int MAXIMUM_POOL_SIZE = 10;
    /**
     * 工作队列长度
     */
    private static final int CAPACITY = 100;

    /**
     * 线程名称前缀
     */
    private static final String PREFIX = "common";

    /**
     * commonThreadPool 方法是 创建公共线程池,用于所有业务
     *
     * @return 公共线程池
     * @author dongyinggang
     * @date 2021/1/12 10:58
     */
    @Bean
    public ExecutorService commonThreadPool() {
        return ThreadPoolUtil.buildThreadPool(PREFIX, CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, CAPACITY);
    }
}
