package com.example.demo;

import com.example.demo.feign.feignlog.EnableFeignLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * DemoApplication 类是 springboot启动类
 * MapperScan 和 @Mapper 必须得至少有一个,否则不会扫描到对应的 Mapper 对象
 *
 * @author dongyinggang
 * @date 2020/11/21 18:56
 */
@Slf4j
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableFeignClients
@EnableFeignLog
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(DemoApplication.class, args);
        } catch (Exception e) {
            log.error("启动异常", e);
        }
    }

}
