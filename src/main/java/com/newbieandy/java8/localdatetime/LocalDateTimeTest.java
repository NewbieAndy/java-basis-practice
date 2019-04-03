package com.newbieandy.java8.localdatetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mchao on 2016/11/3.
 */
public class LocalDateTimeTest {
    private static final String L_FOR_MAT_PATTERN = "yyyy-MM-dd";

    public static void main(String[] args) {
//        LocalDateTime dateTime = dateTimeStr2LocalDateTime("2011-09-11");
//        System.out.println(dateTime);
//        LocalDate parse = LocalDate.parse("201812-12", DateTimeFormatter.ISO_LOCAL_DATE);
        //DateTimeException
        //DateTimeParseException
//        System.out.println(parse);
        week();
        String fileName = "卡面订单-"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss - n"))
                + ".xlsx";
        System.out.println(fileName);

        String fileName1 = "卡面订单-"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss - n"))
                + ".xlsx";
        System.out.println(fileName1);
    }

    private static void week() {
        DayOfWeek currentDayOfWeek = LocalDateTime.now().getDayOfWeek();
        int currentDayOfWeekValue = currentDayOfWeek.getValue();
        Integer weekDayFrom = 1;
        Integer weekDayTo = 7;
        if (currentDayOfWeekValue > weekDayTo || currentDayOfWeekValue < weekDayFrom) {
            System.out.println(27);
        }
    }


    private static void test() {
        LocalTime currentShowTime = LocalTime.of(22, 12, 00);
        //如果当前场次放映时间在有效放映时间之外,直接不通过
        LocalTime startTime = LocalTime.of(0, 0, 0);
        LocalTime endTime = LocalTime.of(0, 0, 0);
        //截止时间是次日凌晨的情况
        if (LocalTime.of(0, 0, 0).equals(endTime)) {
            if (currentShowTime.isBefore(startTime)) {
                System.out.println("33");
            }
        } else {
            if (currentShowTime.isBefore(startTime) || currentShowTime.isAfter(endTime)) {
                System.out.println("37");
            }
        }

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
                System.out.println(startTime + "-" + endTime);
                break;
            } else {
                System.out.println(startTime + "-" + newEndTime);
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
