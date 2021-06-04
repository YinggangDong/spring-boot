package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * NacosPassWordUtil 类是 nacos密码生成工具类
 *
 * @author dongyinggang
 * @date 2021-06-04 13:20
 **/
public class NacosPassWordUtil {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
