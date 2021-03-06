package com.example.demo.api;

/**
 * ConfigApi 接口是 配置文件参数测试接口
 *
 * @author dongyinggang
 * @date 2021-01-28 17:50
 **/
public interface ConfigApi {

    /**
     * testConf 方法是 测试 @ConfigurationProperties 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/26 14:03
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
