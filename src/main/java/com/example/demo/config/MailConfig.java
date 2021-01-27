package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MailConfig 类是 邮箱配置类
 * 必须有set方法,才能够进行配置文件的读取
 * 会在target/classes/META-INF下的spring-configuration-metadata.json
 * 中增加一条记录
 *
 * @author dongyinggang
 * @date 2021-01-26 13:53
 **/
@Component
@ConfigurationProperties(prefix = "spring.mail")
@Data
//@PropertySource(value = {"classpath:application-dev.yml"})
public class MailConfig {

    /**
     * 提供邮件服务的host
     */
//    @Value("${spring.mail.host}")
    public String host;

    /**
     * 提供邮件服务的端口
     */
//    @Value("${spring.mail.port}")
    public String port;

    /**
     * 发件箱地址
     */
//    @Value("${spring.mail.username}")
    public String username;

    /**
     * 发件箱密码(或授权码)
     */
//    @Value("${spring.mail.password}")
    public String password;

    public String testField;

    public String getMailConfig() {
        return "mailConfig-->host:" + this.host + ",port:" + this.port
                + ",address:" + this.username + ",password:" + this.password
                + ",testFiled:" + this.testField;
    }

}
