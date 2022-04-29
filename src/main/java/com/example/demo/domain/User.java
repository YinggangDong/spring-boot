package com.example.demo.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * User 类是 用户类
 *
 * @author dongyinggang
 * @date 2020-11-23 14:54
 **/
@Data
public class User {

    @NotNull(message = "不为null")
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}
