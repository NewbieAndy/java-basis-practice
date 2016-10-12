package com.newbieandy.java5.annotation;

import com.newbieandy.java5.annotation.myannotation.CarColor;
import com.newbieandy.java5.annotation.myannotation.CarType;
import lombok.Getter;
import lombok.Setter;

/**
 * 定义汽车类
 * 用来使用自定义注解
 * Created by mchao on 2016/10/12.
 */
@Getter
@Setter
public class RedSmallCar {

    @CarType("small")
    private String type;

    @CarColor(CarColor.Color.RED)
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
