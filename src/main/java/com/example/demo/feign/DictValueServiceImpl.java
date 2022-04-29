package com.example.demo.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * DictValueServiceImpl 类是
 *
 * @author dongyinggang
 * @date 2022-04-26 10:50
 **/

@Service
@Slf4j
public class DictValueServiceImpl implements DictValueService {


    @Override
    public void testConfByValue() {
        log.info("hello fake feignClient!");
    }
}
