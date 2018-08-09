package com.newbieandy.java8.lambda;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mchao on 2016/10/12.
 */
public class BasisDemo {
    public static void main(String[] args) throws InterruptedException {
//        flatMapTest();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 12, 1, 3, 1, 415, 1231);
        System.out.println(list);
        List<List<Integer>> lists = splitList(list, 5);
        lists.forEach(System.out::println);
    }

    private static int get() {
        return 1;
    }


    @Data
    public static class Student {
        private String id;
        private LocalDateTime date = LocalDateTime.now();
    }

    /**
     * 列表拆分
     *
     * @param list        长列表
     * @param subListSize 字列表长度
     * @param <T>
     * @return
     */
    private static <T> List<List<T>> splitList(List<T> list, int subListSize) {
        List<List<T>> resultList = new ArrayList<>();
        //更新批次长度
        int size = list.size();
        if (size > subListSize) {
            int totalTimes = (size + subListSize - 1) / subListSize;
            for (int times = 1; times <= totalTimes; times++) {
                int startIdx = (times - 1) * subListSize;
                int endIdx = size < startIdx + subListSize ? size : startIdx + subListSize;
                List<T> subList = list.subList(startIdx, endIdx);
                resultList.add(subList);
            }
        } else {
            resultList.add(list);
        }
        return resultList;
    }

    private static void flatMapTest() {
        List<List<String>> pList = new ArrayList<>();
        List<String> list1 = Arrays.asList("andy", "tom", "amy");
        List<String> list2 = Arrays.asList("张三", "李四", "王五");
        pList.add(list2);
        pList.add(list1);
        List<String> collect = pList.stream().flatMap((x) -> x.stream()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
