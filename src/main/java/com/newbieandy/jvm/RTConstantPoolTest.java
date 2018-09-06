package com.newbieandy.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public class RTConstantPoolTest {
    public static void main(String[] args) throws InterruptedException {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("initHeap:" + usage.getInit());
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
//            Thread.sleep(10);
            list.add(String.valueOf(i++).intern());
            if (i == Integer.MAX_VALUE - 10) {
                break;
            }
        }
        list.forEach(s -> System.out.println(s));
    }
}
