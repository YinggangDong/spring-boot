package com.example.demo.service.impl;

import com.example.demo.config.MailConfig;
import com.example.demo.config.MailConfigByValue;
import com.example.demo.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
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

    /**
     * testConf 方法是 测试 @ConfigurationProperties 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/26 14:07
     */
    @Override
    public void testConf() {
        mailConfig.mailInfo();
        log.info("通过 @ConfigurationProperties 加载配置文件完毕");
    }

    /**
     * testConfByValue 方法是 测试 @Value 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/29 13:56
     */
    @Override
    public void testConfByValue(){
        mailConfigByValue.getMailConfig();
        log.info("通过 @Value 加载配置文件完毕");
    }
}
