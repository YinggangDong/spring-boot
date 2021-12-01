package com.example.demo.util.resttemplate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * UseRestTemplate 类是 使用RestTemplate
 *
 * @author dongyinggang
 * @date 2021-09-10 13:57
 **/
public class UseRestTemplate {

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping
    public String sayHi() {
        String result = restTemplate.getForObject("http://127.0.0.1:/test/hello", String.class);
        return result;
    }

}
