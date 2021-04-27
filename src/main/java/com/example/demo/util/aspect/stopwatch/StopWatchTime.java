package com.example.demo.util.aspect.stopwatch;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * StopWatchTime 接口是 StopWatch计算耗时的注解
 *
 * @author dongyinggang
 * @date 2021-04-13 19:59
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface StopWatchTime {
    String value() default "";
}
