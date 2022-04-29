package com.example.demo.verifyaspect;

/**
 * DemoAspect 类是
 *
 * @author dongyinggang
 * @date 2022-04-26 15:49
 **/

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * aspect切面，用于测试是否成功切入
 */
@Aspect
@Order(-10)
@Component
public class DemoAspect {

    @Before("@annotation(demo)")
    public void beforeDemo(JoinPoint point, Demo demo) {
        System.out.println("before demo");
    }

    @After("@annotation(demo)")
    public void afterDemo(JoinPoint point, Demo demo) {
        System.out.println("after demo");
    }

}
