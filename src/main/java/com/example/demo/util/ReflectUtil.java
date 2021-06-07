package com.example.demo.util;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * ReflectUtil 类是 反射工具类
 *
 * @author dongyinggang
 * @date 2021-06-07 10:53
 **/
public class ReflectUtil {

    /**
     * setFieldValue 方法是 通过反射调用方法设置字段值
     * 仅支持一个参数的情况
     *
     * @param object     对象
     * @param methodName 方法名称
     * @param value      字段value
     * @author dongyinggang
     * @date 2021/6/7 8:44
     */
    public static void setFieldValue(Object object, String methodName, Object value) throws Exception {
        Class<?> clazz = object.getClass();
        Method method = clazz.getMethod(methodName, value.getClass());
        method.invoke(object, value);
    }

    public static void main(String[] args) throws Exception {
        B b = new B();
        setFieldValue(b, "setId", "123");
        setFieldValue(b, "setName", "123");
        System.out.println(b.getId() + "  " + b.getName());
    }
}

@Data
class A {
    private String id;
}

@Data
class B extends A {
    private String name;
}