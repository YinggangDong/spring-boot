package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MailConfig 类是 邮箱配置类
 *
 * @author dongyinggang
 * @date 2021-01-26 13:53
 **/
@Component
@ConfigurationProperties(prefix = "spring.mail")
//@PropertySource(value = {"classpath:application-dev.yml"})
public class MailConfig {

    /**
     * 提供邮件服务的host
     */
//    @Value("${mail.host}")
    public String host;

    /**
     * 提供邮件服务的端口
     */
//    @Value("${mail.port}")
    public String port;

    /**
     * 发件箱地址
     */
//    @Value("${mail.address}")
    public String address;

    /**
     * 发件箱密码(或授权码)
     */
//    @Value("${mail.password}")
    public String password;

    public String getMailConfig() {
        return "mailConfig-->host:" + this.host + ",port:" + this.port
                + ",address:" + this.address + ",password:" + this.password;
    }

}
