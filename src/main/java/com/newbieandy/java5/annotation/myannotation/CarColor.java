package com.newbieandy.java5.annotation.myannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 汽车颜色
 * Created by mchao on 2016/10/12.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CarColor {

    Color value() default Color.BLACK;

    enum Color {
        BLACK,
        RED,
        BLUE,
        YELLO,
        GREEN;
    }
}
