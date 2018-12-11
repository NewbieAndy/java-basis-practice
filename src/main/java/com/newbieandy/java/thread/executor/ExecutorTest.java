package com.newbieandy.java.thread.executor;

import java.util.Arrays;
import java.util.List;

public class ExecutorTest {
    public static void main(String[] args) {
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
//        String s = "5bebbbbd898ad500013479b7|微信图片_20170621161532.gif";
//        String[] split = s.split("\\|");
//        System.out.println(split);
//        String a = "<td class=\" center\">浙江翠苑电影大世界-时代在线</td>";
//
//
//        for (int i=1;i<30;i++){
//            System.out.println("<option value=\""+i+"\">"+i+"日</option>");
//        }
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now.getDayOfWeek());
//        System.out.println(DayOfWeek.of(1));
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list);
        System.out.println(list.subList(0, 2));
        System.out.println(list.subList(3, 8));
        System.out.println(list);
    }
}
