package com.example.demo.service.impl;

import com.example.demo.config.MailConfig;
import com.example.demo.config.MailConfigByValue;
import com.example.demo.service.ConfigService;
import com.example.demo.service.HelloService;
import com.example.demo.util.aspect.stopwatch.StopWatchTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ConfigServiceImpl 类是 配置文件参数测试Service类
 *
 * @author dongyinggang
 * @date 2021-01-29 13:50
 **/
@Service
@Slf4j
public class ConfigServiceImpl implements ConfigService {


    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private MailConfigByValue mailConfigByValue;
    @Autowired
    private HelloService helloService;

    /**
     * testConf 方法是 测试 @ConfigurationProperties 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/26 14:07
     */
    @Override
    @StopWatchTime("加载配置文件")
    public void testConf() {
        mailConfig.mailInfo();
        //调用其他类的时候,可以直接获取到代理类
        helloService.hello(1);
        //如果出现自调用,需要通过以下方式获取到增强后的代理类
        ((ConfigServiceImpl) AopContext.currentProxy()).testConfByValue();

    }

    /**
     * testConfByValue 方法是 测试 @Value 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/29 13:56
     */
    @Override
    @StopWatchTime("测试")
    public void testConfByValue() {
        mailConfigByValue.getMailConfig();
        log.info("通过 @Value 加载配置文件完毕");
    }
}
