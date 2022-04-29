package com.example.demo.api.controller;

import com.example.demo.api.ConfigApi;
import com.example.demo.feign.DictValueService;
import com.example.demo.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigController 类是 配置文件参数测试类
 *
 * @author dongyinggang
 * @date 2021-01-28 17:50
 **/
@Slf4j
@RestController
@RequestMapping("config")
public class ConfigController implements ConfigApi {

    @Autowired
    private ConfigService configService;
    @Autowired
    private DictValueService dictValueService;

    /**
     * testConf 方法是 测试 ConfigurationProperties 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/26 14:03
     */
    @Override
    @GetMapping("test_conf")
    public void testConf() {
        configService.testConf();
    }

    /**
     * testConfByValue 方法是 测试 @Value 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/29 13:56
     */
    @Override
    @GetMapping("test_conf_by_value")
    public void testConfByValue() {
        log.info("测试 @Value 加载配置文件的属性");
        configService.testConfByValue();
    }

    /**
     * testConfByValue 方法是 测试 @Value 加载配置文件的属性
     *
     * @author dongyinggang
     * @date 2021/1/29 13:56
     */
    @GetMapping("test_conf_by_value_feign")
    public void testConfByValueFeign() {
        log.info("测试 @Value 加载配置文件的属性");
        dictValueService.testConfByValue();
    }


}
