package com.example.demo.verifyaspect;

import com.example.demo.config.feignlog.FakeFeignClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * DemoService 类是
 *
 * @author dongyinggang
 * @date 2022-04-26 15:48
 **/
@Service
public interface DemoService {

    @FakeFeignClient
    List<Map<String, Object>> selectAll();
}
