package com.example.demo.service;

/**
 * HelloService 接口是 测试service
 *
 * @author dongyinggang
 * @date 2020-11-23 14:59
 **/
public interface HelloService {

    /**
     * hello 方法是 测试
     *
     * @param id 用户id
     * @return 用户名称
     * @author dongyinggang
     * @date 2020/11/23 15:58
     */
    String hello(Integer id);

    /**
     * hello 方法是 测试
     *
     * @param id 用户id
     * @return 用户名称
     * @author dongyinggang
     * @date 2020/11/23 15:58
     */
    String helloList(Integer id);

    String testProcess();

    /**
     * testThreadPool 方法是 测试集成的公共线程池
     *
     * @return 结果
     * @author dongyinggang
     * @date 2021/1/23 10:50
     */
    String testThreadPool();

    /**
     * testConf 方法是 测试 ConfigurationProperties 加载配置文件的属性
     *
     * @return mailConfig的值
     * @author dongyinggang
     * @date 2021/1/26 14:07
     */
    String testConf();
}
