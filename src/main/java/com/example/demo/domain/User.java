package com.example.demo.domain;

import lombok.Data;

/**
 * User 类是 用户类
 *
 * @author dongyinggang
 * @date 2020-11-23 14:54
 **/
@Data
public class User {

    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}
