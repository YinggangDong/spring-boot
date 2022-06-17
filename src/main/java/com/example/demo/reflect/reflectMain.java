package com.example.demo.reflect;

import java.lang.reflect.Field;

/**
 * reflectMain 类是
 *
 * @author dongyinggang
 * @date 2022-06-17 08:19
 **/
public class reflectMain {

    public static void main(String[] args) {
        Class abstractClass = TargetClass.class;
        Class extendClass = ExtendTargetClass.class;


        try {
            //Field field = abstractClass.getDeclaredField("name");
            //field.setAccessible(true);
            ////Object instance = abstractClass.newInstance();
            //Object o = field.get(abstractClass);
            //System.out.println(o);

            Field field1 = extendClass.getSuperclass().getDeclaredField("name");
            field1.setAccessible(true);
            Object newInstance = extendClass.newInstance();
            field1.set(newInstance, "dongyinggang");
            Object o1 = field1.get(newInstance);
            System.out.println(o1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
