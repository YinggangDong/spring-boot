package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MailConfigByValue 类是 通过value加载配置文件的mail配置
 *
 * @author dongyinggang
 * @date 2021-01-28 14:16
 **/
@Component
public class MailConfigByValue {
    /**
     * 提供邮件服务的host
     */
    @Value("${spring.mail.host}")
    public String host;

    /**
     * 提供邮件服务的端口
     */
    @Value("${spring.mail.port}")
    public String port;

    /**
     * 发件箱地址
     */
    @Value("${spring.mail.username}")
    public String username;

    /**
     * 发件箱密码(或授权码)
     */
    @Value("${spring.mail.password}")
    public String password;

    /**
     * getMailInfo 方法是 输出本类的属性值
     *
     * @author dongyinggang
     * @date 2021/1/29 13:57
     */
    public void getMailConfig() {
        System.out.println("mailConfig通过 @Value 注解加载");
        System.out.println("host:" + this.host);
        System.out.println("port:" + this.port);
        System.out.println("username:" + this.username);
        System.out.println("password:" + this.password);
    }
}
