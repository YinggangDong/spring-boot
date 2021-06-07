package com.example.demo.api.controller;

import com.example.demo.api.HelloApi;
import com.example.demo.domain.User;
import com.example.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * StopWatchTime可用
     *
     * @return 测试结果
     * @author dongyinggang
     * @date 2020/11/11 18:49
     */
//    @StopWatchTime("say hello")
    @GetMapping("hello")
    @Override
    public String hello(Integer id) {
        log.info("测试方法 hello 方法,入参为{}", id);
        String realName = helloService.hello(id);
        log.info("测试方法 hello 方法,出参为{}", realName);
        return "hello," + realName;
    }

    /**
     * helloList 方法是 测试 mybatis 查询不到符合条件的记录时是返回null还是空的list的问题
     * 结论：返回size=0的list
     *
     * @return 测试结果
     * @author dongyinggang
     * @date 2020/11/11 18:49
     */
    @GetMapping("helloList")
    @Override
    public String helloList(Integer id) {
        log.info("测试方法 helloList方法,入参为{}", id);
        String size = helloService.helloList(id);
        log.info("测试方法 hello方法,出参为{}", size);
        return "hello," + size;
    }

    /**
     * helloPost 方法是 测试POST方法的参数接收
     *
     * @param user 含id的请求入参
     * @return 测试结果
     * @author dongyinggang
     * @date 2021/1/4 8:19
     */
    @PostMapping("hello_post")
    @Override
    public String helloPost(@RequestBody User user) {
        log.info("测试方法 helloPost 方法,入参为{}", user);
        String realName = helloService.hello(user.getId());
        log.info("测试方法 helloPost 方法,出参为{}", realName);
        return "helloPost," + realName;
    }

    /**
     * testProcess 方法是 测试存储过程调用
     *
     * @return 调用结果
     * @author dongyinggang
     * @date 2021/1/22 19:25
     */
    @GetMapping("test_process")
    @Override
    public String testProcess() {
        return helloService.testProcess();
    }

    /**
     * testThreadPool 方法是 测试集成的公共线程池
     *
     * @return 结果
     * @author dongyinggang
     * @date 2021/1/23 10:50
     */
    @GetMapping("test_thread_pool")
    @Override
    public String testThreadPool() {
        log.info("测试集成的线程池");
        return helloService.testThreadPool();
    }

}
