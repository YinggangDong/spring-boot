package com.example.demo.verifyaspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * DemoServiceImpl 类是
 *
 * @author dongyinggang
 * @date 2022-04-26 18:39
 **/
@Service
public class DemoServiceImpl implements DemoService {


    @Autowired
    DemoMapper demoMapper;

    @Override
    public List<Map<String, Object>> selectAll() {
        return demoMapper.selectAll();
    }
}
