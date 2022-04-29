package com.example.demo.feign;


import com.example.demo.config.feignlog.FakeFeignClient;

/**
 * DictValueService 接口是 bbpf的字典相关feign调用
 *
 * @author dongyinggang
 * @date 2020/11/3 15:10
 */
public interface DictValueService {

    @FakeFeignClient
    void testConfByValue();


}
