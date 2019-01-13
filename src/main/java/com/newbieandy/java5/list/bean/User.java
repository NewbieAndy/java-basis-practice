package com.newbieandy.java5.list.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * Created by mchao on 2017/12/1.
 */
@Getter
@Setter
@ToString
public class User {
    private String name;
    private int age;
    private String desc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age;
    }

    @Override
    public int hashCode() {

        return Objects.hash(age);
    }
}
