package com.newbieandy.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCreateTest {
    public static void main(String[] args) {
        //通过数组创建
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
//        integerStream.limit(2).forEach(System.out::println);
        integerStream.skip(2).forEach(System.out::println);
        //通过集合创建
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4).stream();
        //通过generate创建
//        Stream<String> stringStream = Stream.generate(() -> "a");
//        stringStream.skip(3).forEach(System.out::println);
//        //通过iterate创建
//        Stream<Integer> integerStream1 = Stream.iterate(1, x -> x + 1);
//        integerStream1.skip(3).forEach(System.out::println);
//        //通过其他API
//        String s = "abc";
//        IntStream chars = s.chars();
    }
}
