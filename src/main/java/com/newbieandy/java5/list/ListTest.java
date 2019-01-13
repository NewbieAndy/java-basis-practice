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
//        listSliceTest();
//        listRemoveallTest();
//        arraysAsListTest();
        removeListTest();

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

    private static void listRemoveallTest() {
        List<User> list1 = getList1();
        List<User> list2 = getList2();
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list1.removeAll(list2));
        list2.removeAll(list1);
        System.out.println(list1);
        System.out.println(list2);

    }

    private static List<User> getList1() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(1);
        user.setDesc("aaa");
        user.setName("aaa");
        list.add(user);
        return list;
    }

    private static List<User> getList2() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(1);
        user.setDesc("bbb");
        user.setName("bbb");
        list.add(user);
        User user1 = new User();
        user1.setAge(2);
        user1.setDesc("ccc");
        user1.setName("ccc");
        list.add(user1);
        return list;
    }

    private static void arraysAsListTest() {
        List<Integer> list = Arrays.asList(1, 3, 4, 5);
        list.add(0);
        System.out.println(list);
    }

    private static void removeListTest() {
        List<String> list1 = new ArrayList<>();
        list1.add("3453454351");
        list1.add("3453454352");
        list1.add("3453454353");
        list1.add("3453454354");
        list1.add("3453454355");
        list1.add("3453454356");
        list1.add("3453454357");
        List<String> list2 = new ArrayList<>();
        list2.add("3453454351");
        list2.add("3453454352");
        list2.add("3453454353");
        System.out.println(list1);
        System.out.println(list2);
        list1.removeAll(list2);
        System.out.println(list1);
        System.out.println(list2);
    }

}
