package com.newbieandy.java.reflect.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by mchao on 2016/10/28.
 */
@Getter
@Setter
@ToString
public class MiddleStudent extends Student implements Serializable {
    private static final long serialVersionUID = 398043935821586300L;
    private String subject;
}
