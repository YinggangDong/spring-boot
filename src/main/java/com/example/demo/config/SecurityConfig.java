package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig 类是 禁用 Spring Security 引入的登录校验
 *
 * @author dongyinggang
 * @date 2021-06-07 14:58
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置不需要登录验证
        http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
    }
}

