package com.example.demo.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FeignDemoController 类是
 *
 * @author dongyinggang
 * @date 2022-05-16 13:35
 **/
@RequestMapping("/feign")
@RestController
public class FeignDemoController {

    @Autowired
    private FeignDemoService feignDemoService;

    /**
     * sayHi 方法是 返回hi
     *
     * @return hi！
     * @author dongyinggang
     * @date 2022/5/18 16:58
     */
    @GetMapping("/hi")
    public String sayHi() {
        return "hi!";
    }

    /**
     * feignSayHi 方法是 通过feign调用本controller的sayHi方法
     *
     * @return hi！
     * @author dongyinggang
     * @date 2022/5/18 16:57
     */
    @GetMapping("/feign_hi")
    public String feignSayHi() {
        return feignDemoService.sayHi();
    }


}
