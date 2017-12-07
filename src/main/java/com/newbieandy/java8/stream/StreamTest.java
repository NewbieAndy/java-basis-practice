package com.newbieandy.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mchao on 2017/11/15.
 */
public class StreamTest {
    public static void main(String[] args) {

//        listTest();
//        filterList();
        intStreamTest();
    }
    private static void intStreamTest(){
        IntStream.of(1,2,3,4,5,6).forEach(i-> System.out.println(i));
        IntStream.range(0,10).forEach(i-> System.out.println(i));
        IntStream.rangeClosed(0,10).forEach(i-> System.out.println(i));
    }


    /**
     * 普通foreach与平行流foreach 区别
     */
    private static void listTest(){
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
        System.out.println("foreach...,保证顺序");
        intList.forEach(integer -> System.out.println(integer));
        System.out.println("parallelStream foreach...,不保证顺序");
        intList.parallelStream().forEach(integer -> System.out.println(integer));
        System.out.println("parallelStream foreachOrdered...,保证顺序");
        intList.parallelStream().forEachOrdered(integer -> System.out.println(integer));
        System.out.println("stream foreach...,保证顺序");
        intList.stream().forEachOrdered(integer -> System.out.println(integer));

    }
    private static void filterList(){
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        List<Integer> collect = getUsers().stream().map(user -> user.getAge()).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(intList);
        boolean b = intList.removeAll(collect);
        System.out.println(b);
        intList.removeAll(collect);
        System.out.println(intList);
    }

    /**
     * 获取数据源
     * @return
     */
    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(1 + i);
            users.add(user);
        }
        return users;
    }


    static class User {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
