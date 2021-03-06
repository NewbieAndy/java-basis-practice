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
public class Student extends YoungPerson {
    public static String NAME = "Student";

    static {
        System.out.println("Student init...");
    }

    /**
     * 年级
     */
    private int grade;
    /**
     * 班级
     */
    private int classes;
}
