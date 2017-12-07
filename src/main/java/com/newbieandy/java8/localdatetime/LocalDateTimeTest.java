package com.newbieandy.java8.localdatetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mchao on 2016/11/3.
 */
public class LocalDateTimeTest {
    private static final String L_FOR_MAT_PATTERN = "yyyy-MM-dd";

    public static void main(String[] args) {
        LocalDateTime dateTime = dateTimeStr2LocalDateTime("2011-09-11");
        System.out.println(dateTime);
    }


    private static LocalDateTime dateTimeStr2LocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(L_FOR_MAT_PATTERN));
    }

    private static void busTest() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(1);
        long timeSpanSeconds = 600;

        while (true) {
            LocalDateTime newEndTime = startTime.plusSeconds(timeSpanSeconds);
            if (newEndTime.isAfter(endTime)) {
                System.out.println(startTime+"-"+endTime);
                break;
            } else {
                System.out.println(startTime+"-"+newEndTime);
                startTime = startTime.plusSeconds(timeSpanSeconds);
            }
        }
    }

    private static void beforeTimeTest() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(-1);
        boolean after = start.isBefore(end);
        System.out.println(after);
    }

    /**
     * 时间差测试
     */
    private static void periodTest() {
        LocalDateTime start = LocalDateTime.now().plusSeconds(19);
        LocalDateTime end = LocalDateTime.now().minusMinutes(100);
        Duration between = Duration.between(start, end);
        long l = between.toMinutes();
        long l1 = between.toMillis();
        long seconds = between.getSeconds();
        System.out.println(seconds);
        System.out.println(l);
        System.out.println(l1);
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
