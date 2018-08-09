package com.newbieandy.java5.list;

import com.newbieandy.java5.list.bean.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mchao on 2017/12/1.
 */
public class ListTest {
    public static void main(String[] args) {
//        List<User> list1 = getList1();
//        List<User> list2 = getList2();
//        list1.removeAll(list2);
//        System.out.println(list1);
//        List<User> list = new ArrayList<>();
//        list.removeAll(null);
//        System.out.println(list);
        listSliceTest();

    }

    private static void listSliceTest() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "ga", "gea");
        System.out.println(list);
        int l = 6;

        int size = list.size();
        if (size > l) {
            int i = size / l + 1;
            System.out.println(i);
            for (int times = 1; times <= i; times++) {
                int startIdx = (times - 1) * l;
                int endIdx = size < startIdx + l ? size : startIdx + l;
                List<String> strings = list.subList(startIdx, endIdx);
                System.out.println(strings);
            }
        } else {
            System.out.println(list);
        }


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
