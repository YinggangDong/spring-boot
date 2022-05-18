package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * FeignDemoService 类是
 *
 * @author dongyinggang
 * @date 2022-05-16 13:34
 **/
@FeignClient(name = "feignName", url = "127.0.0.1:${server.port}/")
public interface FeignDemoService {

    @GetMapping("/feign/hi")
    String sayHi();
}
