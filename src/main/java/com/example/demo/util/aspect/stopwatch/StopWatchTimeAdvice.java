package com.example.demo.util.aspect.stopwatch;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import java.util.Arrays;

/**
 * StopWatchTimeAdvice 类是 StopWatch记录耗时的切面类
 * 1.通过@Aspect 注解声明一个切面
 * 2.通过@Component 让此切面成为Spring容器管理的Bean
 *
 * @author dongyinggang
 * @date 2021-04-13 20:02
 **/
@Aspect
@Component
@Slf4j
public class StopWatchTimeAdvice {

    /**
     * invoke 方法是 再切点做的操作：记录当前方法耗时
     * 通过@Around注解声明一个建言，并使用定义了自定义注解@StopWatchTime的方法作为切入点
     *
     * @param thisJoinPoint thisJoinPoint
     * @param stopWatchTime stopWatchTime注解
     * @return 结果
     * @author dongyinggang
     * @date 2021/4/13 20:06
     */
    @Around("@annotation(stopWatchTime)")
    public Object invoke(ProceedingJoinPoint thisJoinPoint, StopWatchTime stopWatchTime) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
        // 4.获取注解上的属性，如果无就默认当前的方法名“ methodSignature.getName() ”
        String name = StringUtils.isEmpty(stopWatchTime.value()) ? methodSignature.getName() : stopWatchTime.value();
        Object[] args = thisJoinPoint.getArgs();
        //排除BindingResult的参数内容
        Object[] argRes = Arrays.stream(args).filter(arg->!(arg instanceof BindingResult)).toArray();
        //打印入参
        log.info("{} {} 入参：{}", name, methodSignature.getName(), JSON.toJSONString(argRes));
        StopWatch stopWatch = new StopWatch(name);
        stopWatch.start();
        // 5.作好StopWatch的前期准备后，执行切入点的方法体
        Object object = thisJoinPoint.proceed();
        // 6.执行完成后打印执行结果
        stopWatch.stop();
        //打印出参
        log.info("{} 结束,耗时信息: {}ms \n返回结果：{}", name, stopWatch.getTotalTimeMillis(),
                JSON.toJSONString(object));

        return object;
    }

}
