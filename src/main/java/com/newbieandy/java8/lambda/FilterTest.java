package com.newbieandy.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
//        test1();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            list.add(i);
        }
        long l = System.currentTimeMillis();
        list.parallelStream().forEach(System.out::println);
        list.stream().forEach(System.out::println);
        long l1 = System.currentTimeMillis();
        System.out.println("time:" + (l1 - l));
        System.out.println(list);
//        List<Long> list1 = Arrays.asList(1l, 3l, 4l, 5l, 6L);
////        list1.stream().forEach(i->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(i);
//        });
    }

    private static void test1() {
        List<Long> list1 = Arrays.asList(1l, 3l, 4l, 5l, 6L);
        System.out.println(list1);
        List<Long> list2 = Arrays.asList(3l, 4l, 5l, 6L);
        System.out.println(list2);
        List<Long> collect = list2.stream().filter(l -> !list1.contains(l)).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect.isEmpty());
    }
}
