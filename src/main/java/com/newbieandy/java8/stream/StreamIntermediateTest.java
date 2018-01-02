package com.newbieandy.java8.stream;

import com.newbieandy.java8.bean.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 流中间操作测试
 */
public class StreamIntermediateTest {
    public static void main(String[] args) {
        mapTest();
    }

    private static void mapTest() {
        List<String> strList = Arrays.asList("a","b","c","d","e","f","g");
        List<String> newStrList = strList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(strList);
        System.out.println(newStrList);
        List<Person> personList = new ArrayList<>();
        IntStream.rangeClosed(1,10).forEach(age->{
            personList.add(new Person("andy"+age,age));
        });
        System.out.println(personList);
        List<String> list = personList.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void Test1() {

    }

    private static void Test2() {

    }

    private static void Test3() {

    }

    private static void Test4() {

    }

    private static void Test5() {

    }

    private static void Test6() {

    }

    private static void Test7() {

    }

    private static void Test8() {

    }

    private static void Test9() {

    }

    private static void Test10() {

    }
}
