package com.example.demo.service;

/**
 * ConfigService 接口是 配置文件参数测试Service接口
 *
 * @author dongyinggang
 * @date 2021-01-29 13:50
 **/
public interface ConfigService {


    /**
     * testConf 方法是 测试 ConfigurationProperties 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/26 14:07
     */
    void testConf();

    /**
     * testConfByValue 方法是 测试 @Value 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/29 13:56
     */
    void testConfByValue();
}
