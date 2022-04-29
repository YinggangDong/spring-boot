package com.example.demo.verifyaspect;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoServiceTest {

    @Autowired
    DemoService demoService;

    @Test
    public void testDemo() {
        demoService.selectAll();
    }
}