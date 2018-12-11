package com.newbieandy.java.finaltest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MutableObj {
    public final String name;
    public final int count;
    public String desc;

    {
        count = 0;
    }

    public MutableObj(String name) {
        this.name = name;
    }

}
