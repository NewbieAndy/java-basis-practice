package com.newbieandy.java5.annotation.myannotation;

import java.lang.reflect.Field;

/**
 * 简单汽车注解处理器
 * 通过反射,获取注解信息发方法如下:
 * 　　方法1：<T extends Annotation> T getAnnotation(Class<T> annotationClass)
 * 返回改程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null。
 * 　　方法2：Annotation[] getAnnotations()
 * 返回该程序元素上存在的所有注解。
 * 　　方法3：boolean is AnnotationPresent(Class<?extends Annotation> annotationClass)
 * 判断该程序元素上是否包含指定类型的注解，存在则返回true，否则返回false.
 * 　　方法4：Annotation[] getDeclaredAnnotations()
 * 返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。
 * （如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以随意修改返回的数组；
 * 这不会对其他调用者返回的数组产生任何影响。
 * Created by mchao on 2016/10/12.
 */
public class CarAnnotationHandler {

    public static void simpleCarHandler(Class clazz) {
        String carType = "汽车类型";
        String carColor = "汽车颜色";

        /**
         * 获取所有的字段
         */
        Field[] declaredFields = clazz.getDeclaredFields();

        //遍历字段
        for (Field field : declaredFields) {
            //如果字段上有汽车类型的注解
            if (field.isAnnotationPresent(CarType.class)) {
                CarType annotation = field.getAnnotation(CarType.class);
                String value = annotation.value();
                System.out.println(carType + "::" + value);
            }
            if (field.isAnnotationPresent(CarColor.class)) {
                CarColor annotation = field.getAnnotation(CarColor.class);
                CarColor.Color value = annotation.value();
                System.out.println(carColor + "::" + value);
            }
        }


    }
}
