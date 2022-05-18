package com.example.demo.feign.feignlog;

import cn.hutool.core.util.StrUtil;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignLogConfig 类是 feign日志配置类
 *
 * @author dongyinggang
 * @date 2022-04-18 14:19
 **/
@Configuration
public class FeignLogConfig {

    /**
     * 1.优先读取配置文件中配置的连接点表达式
     * 2.若不存在，则会默认设置为当前项目启动类所在目录下的任意层级的feign包下的类
     */
    @Value("${feign.path:}")
    private String feignPath;

    /**
     * feignLogAdvisor 方法是 配置Advisor（增强）
     * 设置切入点，织入切面
     *
     * @return 返回增强结果
     * @author dongyinggang
     * @date 2022/4/19 15:51
     */
    @Bean
    public AspectJExpressionPointcutAdvisor feignLogAdvisor() {
        //若未指定连接点,则获取当前项目的启动类所在的根目录下任意层级的feign包作为默认值
        if (StrUtil.isEmpty(feignPath)) {
            feignPath = "execution(* com.example.demo..feign..*(..))";
        }
        //构建增强结果
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        //连接点
        advisor.setExpression(feignPath);
        //拦截器做环绕通知，记录调用的入参、出参、耗时信息,不用注入的方式做是因为common整个没有被扫描,因此不被spring管理
        advisor.setAdvice(new FeignLogInterceptor());
        return advisor;
    }

}
