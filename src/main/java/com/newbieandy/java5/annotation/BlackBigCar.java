package com.newbieandy.java5.annotation;

import com.newbieandy.java5.annotation.myannotation.CarColor;
import com.newbieandy.java5.annotation.myannotation.CarType;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by mchao on 2016/10/12.
 */
@Getter
@Setter
public class BlackBigCar {
    @CarType("big")
    private String type;

    @CarColor(CarColor.Color.BLACK)
    private String color;
}
