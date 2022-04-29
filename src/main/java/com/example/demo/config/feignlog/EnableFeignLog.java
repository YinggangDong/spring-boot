package com.example.demo.config.feignlog;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EnableFeignLog 注解是 feign日志开关
 * 使用方式：
 * 1.在启动类上添加 @EnableFeignLog 注解
 * 2.如果想自己声明切点，需要在配置文件中配置 feignPath 属性，例如：feignPath=execution(* com.snbc.smcp..feign..*(..))
 * 3.若未在配置文件声明切点，则默认当前项目启动类所在路径下的任意层级的feign包内的有 @FeignClient 的所有feign调用接口的方法均记录对应日志
 *
 * @author dongyinggang
 * @date 2022/4/19 15:56
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FeignLogConfig.class)
public @interface EnableFeignLog {

}
