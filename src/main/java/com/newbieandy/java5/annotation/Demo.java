package com.newbieandy.java5.annotation;

import com.newbieandy.java5.annotation.myannotation.CarAnnotationHandler;

import java.math.BigDecimal;

/**
 * Created by mchao on 2016/10/12.
 */
public class Demo {
    /*
     * 一直对java注解模棱两可,只知道用别人的注解,自己也没声明过注解,
     * 理解的不够深刻,今天重新学习一下注解开发
     */

    /*
     * 一.声明注解:
     *      关键字:@interface
     *      成员参数支持类型:
     *          1.基本类型
     *          2.String类型
     *          3.Class类型
     *          4.Enum类型
     *          5.Annotation类型
     *          6.所有类型都支持数组
     * 二.元注解:负责注解其他注解的注解,Java5定义的元注解如下:
     * 1.@Target (目标): 用于描述注解的使用范围,即注解可以用在什么地方,比如是类上还是成员变量上等....
     *         (ElementType)常用取值如下:
     *          1.CONSTRUCTOR:用于描述构造器
     *          2.FIELD:用于描述域
     *          3.LOCAL_VARIABLE:用于描述局部变量
     *          4.METHOD:用于描述方法
     *          5.PACKAGE:用于描述包
     *          6.PARAMETER:用于描述参数
     *          7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
     *
     *
     * 2.@Retention (保留):描述注解的生命周期,即 被描述的注解在什么范围内有效
     *          RetentionPolicy取值如下:
     *          1.SOURCE:在源文件中有效
     *          2.CLASS:在class文件中有效
     *          3.RUNTIME:在运行时有效
     *
     * 3.@Documented (文档):描述是否可以生成文档,标记性元注解,无成员
     * 4.@Inherited (遗传): 描述注解是否可以继承传递,标记性元注解,无成员
     */

    public static void main(String[] args) {
        CarAnnotationHandler.simpleCarHandler(RedSmallCar.class);
        CarAnnotationHandler.simpleCarHandler(BlackBigCar.class);
    }
}
