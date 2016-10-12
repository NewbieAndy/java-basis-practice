package com.newbieandy.java5.annotation.myannotation;

import java.lang.annotation.*;

/**
 * 自定义注解:
 *      汽车类型
 * Created by mchao on 2016/10/12.
 */
@Target(ElementType.FIELD)//作用在字段上
@Retention(RetentionPolicy.RUNTIME)//保留到运行时
@Documented//可以生成文档
public @interface CarType{
    String value() default "小汽车";
}
