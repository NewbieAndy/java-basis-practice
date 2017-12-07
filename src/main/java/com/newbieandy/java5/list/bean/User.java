package com.newbieandy.java5.list.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
