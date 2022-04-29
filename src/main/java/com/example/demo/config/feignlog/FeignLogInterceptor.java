package com.example.demo.config.feignlog;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * FeignLogInterceptor 类是 统一feign日志拦截器
 *
 * @author dongyinggang
 * @date 2022-04-18 14:02
 **/
@Slf4j
public class FeignLogInterceptor implements MethodInterceptor {

    /**
     * 出参、入参的限制长度,输出时仅截取该长度
     */
    private static final int LEN_LIMIT = 300;


    /**
     * getLimitLengthString 方法是 根据传入的对象获取到限制长度的字符串
     *
     * @param object 传入对象
     * @return 限长字符串
     * @author dongyinggang
     * @date 2022/4/14 8:24
     */
    private static String getLimitLengthString(Object object) {

        String json = JSON.toJSONString(object);
        if (json.length() > LEN_LIMIT) {
            json = JSON.toJSONString(object).substring(0, LEN_LIMIT);
        }
        return json;
    }

    /**
     * invoke 方法是 重写invoke方法，用于增强切点方法的日志功能
     *
     * @param invocation 切点
     * @return 原方法返回结果
     * @author dongyinggang
     * @date 2022/4/19 16:31
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        //获取类实现的接口列表,判断是否含有feignClient注解的接口
        FakeFeignClient feignClient = invocation.getThis().getClass().getAnnotation(FakeFeignClient.class);

        //判断是否有feignClient的注解,没有注解直接执行
        if (feignClient == null) {
            log.info("不希望进来的类进来了");
            return invocation.proceed();
        }

        // 1.获取当前的方法名“ methodSignature.getName() ”
        String name = invocation.getMethod().getName();
        Object[] inputParam = invocation.getArguments();
        // 2.打印入参
        String inputJson = getLimitLengthString(inputParam);

        long start = System.currentTimeMillis();
        Object outParam = null;
        try {
            // 3.执行切入点的方法体
            outParam = invocation.proceed();
        } catch (Exception exception) {
            log.error("feign调用异常");
            throw exception;
        } finally {
            // 4.执行完成后打印执行结果,
            String outJson = getLimitLengthString(outParam);
            log.info(" 方法名:{} 入参：{} 耗时信息: {}ms 返回结果：{}",
                    name, inputJson, System.currentTimeMillis() - start, outJson);
        }
        return outParam;
    }
}
