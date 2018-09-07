package com.newbieandy.java.reflect.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by mchao on 2016/10/28.
 */
@Getter
@Setter
@ToString
public class MiddleStudent extends Student implements Serializable {
    static {
        System.out.println("MiddleStudent init...");
    }

    private String subject;


    public void sayHello() {
        System.out.println("Hello I'm MiddleStudent");
    }
}
