package com.newbieandy.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程调试
 */
public class ThreadDebugTest {
    public static void main(String[] args) {
        mt();
    }

    private static void mt() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> output(10));
        executorService.execute(() -> output(100));
    }

    private static void output(int num) {
        for (int i = num; i < num + 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
