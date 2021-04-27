package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MailConfig 类是 邮箱配置类
 * 若使用@ConfigurationProperties注解,被注入字段必须有set方法,才能够完成配置文件属性值的赋值
 * 会在target/classes/META-INF下的spring-configuration-metadata.json中增加一条记录
 *
 * @author dongyinggang
 * @date 2021-01-26 13:53
 **/
@Component
@ConfigurationProperties(prefix = "spring.mail")
@Data
public class MailConfig {

    /**
     * 提供邮件服务的host
     */
    public String host;

    /**
     * 提供邮件服务的端口
     */
    public String port;

    /**
     * 发件箱地址
     */
    public String username;

    /**
     * 发件箱密码(或授权码)
     */
    public String password;



    /**
     * mailInfo 方法是 输出本类的属性值
     * 不要使用get开头命名，会出现启动不了，提示绑定失败的问题
     * 测了一下，加载的时候会去调用所有的get前缀的方法
     *
     * @author dongyinggang
     * @date 2021/1/29 13:57
     */
    public void mailInfo() {
        System.out.println("mailConfig通过 @ConfigurationProperties 注解加载....");
        System.out.println("host:" + this.host);
        System.out.println("port:" + this.port);
        System.out.println("username:" + this.username);
        System.out.println("password:" + this.password);
    }

}
