package com.newbieandy.java.reflect.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by mchao on 2016/10/27.
 */
@Getter
@Setter
@ToString
public class YoungPerson implements Human {
    static {
        System.out.println("YoungPerson init...");
    }

    private String name;
    private int age;
    private int gender;


    protected void sayHello() {
        System.out.println("Hello I'm YoungPerson");
    }
}
