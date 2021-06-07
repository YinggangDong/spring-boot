package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * DemoApplication 类是 springboot启动类
 * MapperScan 和 @Mapper 必须得至少有一个,否则不会扫描到对应的 Mapper 对象
 *
 * @author dongyinggang
 * @date 2020/11/21 18:56
 */
//@MapperScan(value = "com.example.demo.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
//@EnableDiscoveryClient
public class DemoApplication {

    public static void main(String[] args) {
        // 因为nacos的log4j2导致本项目的日志不输出的问题
        // 配置关闭nacos日志
        System.setProperty("nacos.logging.default.config.enabled", "false");
        SpringApplication.run(DemoApplication.class, args);
    }

}
