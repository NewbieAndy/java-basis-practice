package com.newbieandy.java.loop;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mchao on 2017/8/28.
 */
public class LoopSwichTest {
    public static void main(String[] args) {
//        boolean limitSpeed = isInTime(23, 5);
//        System.out.println(limitSpeed);
    }

    private static void foreachTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    }

    /**
     * 判断当前时间是否在指定时间区间
     *
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @return 在指定时间区间返回true, 否则返回false
     */
    private static boolean isInTime(int startTime, int endTime) {
        if (startTime == endTime) {
            return true;
        }
        //获取当前时刻
        LocalDateTime now = LocalDateTime.now();
        int nowHour = now.getHour();
        //起始时间小于结束时间,时间在当天,未跨天
        if (startTime < endTime) {
            if (startTime <= nowHour && nowHour < endTime) {
                return true;
            }
            return false;
        } else {
            //起始时间>结束时间,跨天计算
            if ((startTime <= nowHour && nowHour <= 23) || (0 <= nowHour && nowHour <= endTime)) {
                return true;
            }
            return false;
        }
    }

    private static boolean isStopped(int startTime, int endTime) {
        if (startTime == endTime) {
            return false;
        }
        //获取当前时刻
        LocalDateTime now = LocalDateTime.now();
        int nowHour = now.getHour();
        //起始时间小于结束时间,时间在当天,未跨天
        if (startTime < endTime) {
            if (startTime <= nowHour && nowHour < endTime) {
                return false;
            }
            return true;
        } else {
            //起始时间>结束时间,跨天计算
            if ((startTime <= nowHour && nowHour <= 23) || (0 <= nowHour && nowHour <= endTime)) {
                return false;
            }
            return true;
        }
    }
}
