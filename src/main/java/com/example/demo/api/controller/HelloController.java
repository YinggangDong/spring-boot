package com.example.demo.api.controller;

import com.example.demo.api.HelloApi;
import com.example.demo.domain.User;
import com.example.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * HelloController 类是 Spring boot 项目 测试Controller
 *
 * @author dongyinggang
 * @date 2020-11-11 18:47
 **/
@Slf4j
@RestController
@RequestMapping("test")
public class HelloController implements HelloApi {

    @Autowired
    private HelloService helloService;

    /**
     * hello 方法是 测试
     *
     * @return 测试结果
     * @author dongyinggang
     * @date 2020/11/11 18:49
     */
    @GetMapping("hello")
    @Override
    public String hello(Integer id) {
        log.info("测试方法 hello方法,入参为{}",id);
        String realName =  helloService.hello(id);
        log.info("测试方法 hello方法,出参为{}",realName);
        return "hello" + realName;
    }

    /**
     * hello 方法是 测试
     *
     * @return 测试结果
     * @author dongyinggang
     * @date 2020/11/11 18:49
     */
    @GetMapping("helloList")
    @Override
    public String helloList(Integer id) {
        log.info("测试方法 helloList方法,入参为{}",id);
        String size =  helloService.helloList(id);
        log.info("测试方法 hello方法,出参为{}",size);
        return "hello" + size;
    }

//    public static void main(String[] args) {
//        List<CompletableFuture> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            CompletableFuture cf = CompletableFuture.supplyAsync(()-> {
//                try {
//                    System.out.println("没看懂");
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return 3;
//            });
//            list.add(cf);
//        }
//        CompletableFuture all = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
//        all.thenApply((a)-> {
//            System.out.println("所有线程执行完毕");
//            return "";
//        });
//        all.join();
//    }
}
