package com.example.demo.api;

import com.example.demo.domain.User;

/**
 * HelloApi 接口是 SpringBoot项目测试接口
 *
 * @author dongyinggang
 * @date 2020-11-11 18:47
 **/
public interface HelloApi {

    /**
     * hello 方法是 测试
     *
     * @return 测试结果
     * @author dongyinggang
     * @date 2020/11/11 18:49
     */
    String hello(Integer id);

    /**
     * helloList 方法是 测试 mybatis 查询不到符合条件的记录时是返回null还是空的list的问题
     * 结论：返回size=0的list
     *
     * @return 测试结果
     * @author dongyinggang
     * @date 2020/11/11 18:49
     */
    String helloList(Integer id);

    /**
     * helloPost 方法是 测试POST方法的参数接收
     *
     * @param user 含id的请求入参
     * @return 测试结果
     * @author dongyinggang
     * @date 2021/1/4 8:19
     */
    String helloPost(User user);

    /**
     * testProcess 方法是 测试存储过程调用
     *
     * @return 调动结果
     * @author dongyinggang
     * @date 2021/1/22 19:25
     */
    String testProcess();

    /**
     * testThreadPool 方法是 测试集成的公共线程池
     *
     * @return 结果
     * @author dongyinggang
     * @date 2021/1/23 10:50
     */
    String testThreadPool();

}
