package com.newbieandy.java.thread.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    static CountDownLatch count = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(11);
            count.countDown();
            System.out.println(12);
            count.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(21);
            count.countDown();
            System.out.println(22);
            count.countDown();
        }).start();
        count.await(10, TimeUnit.SECONDS);
        System.out.println(5);
    }
}
