package com.newbieandy.java5.list;

import com.newbieandy.java5.list.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mchao on 2017/12/1.
 */
public class ListTest {
    public static void main(String[] args) {
        List<User> list1 = getList1();
        List<User> list2 = getList2();
        list1.removeAll(list2);
        System.out.println(list1);
        List<User> list = new ArrayList<>();
        list.removeAll(null);
        System.out.println(list);

    }

    private static List<User> getList1() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(1);
        user.setDesc("aaaa");
        user.setName("andy");
        list.add(user);
        return list;
    }

    private static List<User> getList2() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(1);
        user.setDesc("bbb");
        user.setName("andy");
        list.add(user);
        return list;
    }
}
