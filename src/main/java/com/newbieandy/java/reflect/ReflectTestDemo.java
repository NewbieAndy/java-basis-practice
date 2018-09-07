package com.newbieandy.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mchao on 2016/10/27.
 */
public class ReflectTestDemo {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {

//        Class<?> middleStudent = Class.forName("com.newbieandy.java.reflect.bean.MiddleStudent");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        Class<?> middleStudent = classLoader.loadClass("com.newbieandy.java.reflect.bean.MiddleStudent");
        Object newInstance = middleStudent.newInstance();
        for (Method method : middleStudent.getMethods()) {
//            System.out.println(method.getName());
            if ("sayHello".equals(method.getName())) {
                method.invoke(newInstance);
            }
        }
    }

}
