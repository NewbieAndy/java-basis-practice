package com.newbieandy.java.reflect.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by mchao on 2016/10/27.
 */
@Getter
@Setter
@ToString
public class Person implements Serializable {
    private static final long serialVersionUID = -952095743566856955L;
    private String name;
    private int age;
    private int gender;
}
