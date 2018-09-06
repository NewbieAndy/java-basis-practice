package com.newbieandy.java.thread.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    static CountDownLatch count;

    static {
        count = new CountDownLatch(4);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
            count.countDown();
        });
        executorService.execute(() -> {
            try {
                Thread.sleep(2100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
            count.countDown();
        });
        executorService.execute(() -> {
            try {
                Thread.sleep(3200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
            count.countDown();
        });
        executorService.execute(() -> {
            try {
                Thread.sleep(4100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(4);
            count.countDown();
        });
        count.await(100, TimeUnit.SECONDS);
        System.out.println(5);
        executorService.shutdown();
    }
}
