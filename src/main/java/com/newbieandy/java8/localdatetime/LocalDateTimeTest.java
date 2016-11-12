package com.newbieandy.java8.localdatetime;

import java.time.LocalDateTime;

/**
 * Created by mchao on 2016/11/3.
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now + "now");
        LocalDateTime dateTime = now.plusMinutes(1);
        System.out.println(dateTime + "plusMin");
        LocalDateTime dateTime2 = now.plusSeconds(1);
        System.out.println(dateTime2 + "plussec");
        LocalDateTime dateTime1 = now.plusNanos(1000);
        System.out.println(dateTime1 + "plusnanos");
        boolean after = dateTime.isAfter(now);
        System.out.println(after);
    }
}
