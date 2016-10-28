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
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 4706801833540464423L;
    /**
     * 年级
     */
    private int grade;
    /**
     * 班级
     */
    private int classes;
}
