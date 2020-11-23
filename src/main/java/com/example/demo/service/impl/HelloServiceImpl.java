package com.example.demo.service.impl;

import com.example.demo.mapper.HelloMapper;
import com.example.demo.domain.User;
import com.example.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = helloMapper.selectById(id);
        return user.getRealName();
    }
}
