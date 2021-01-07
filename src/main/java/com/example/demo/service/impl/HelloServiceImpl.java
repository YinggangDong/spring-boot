package com.example.demo.service.impl;

import com.example.demo.mapper.HelloMapper;
import com.example.demo.domain.User;
import com.example.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * HelloServiceImpl 类是 demo的Service实现
 *
 * @author dongyinggang
 * @date 2020-11-23 14:59
 **/
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    /**
     * hello 方法是 测试
     *
     * @param id 用户id
     * @return 用户姓名
     * @author dongyinggang
     * @date 2020/11/23 15:00
     */
    @Override
    public String hello(Integer id) {
        //user可能为null
        User user = helloMapper.selectById(id);
        return Optional.ofNullable(user).map(User::getRealName).orElse("未知用户");
    }

    @Override
    public String helloList(Integer id) {
        //userList不会是null,会是一个size为0的空list
        List<User> userList = helloMapper.selectListById(id);
        return userList.size()+"";
    }

    @Override
    public String testProcess(){
        Map<String,Object> map = new HashMap<>();
        map.put("userName", "开发人员");
        map.put("passWord","123");
        map.put("realName","王五");
        map.put("id",null);
        helloMapper.testProcess(map);
        System.out.println(map.get("id"));
        return "";
    }
}
