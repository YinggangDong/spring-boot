package com.example.demo.verifyaspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DemoController 类是
 *
 * @author dongyinggang
 * @date 2022-05-12 15:44
 **/
@Slf4j
@RestController
@RequestMapping("aspect_demo")
public class DemoController {
    @Resource
    private DemoService demoService;

    @GetMapping("/test_aspect")
    public void testAspect() {
        log.info("测试切面");
        demoService.selectAll();
    }
}
