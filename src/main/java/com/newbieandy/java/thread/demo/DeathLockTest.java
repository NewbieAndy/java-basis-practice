package com.newbieandy.java.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeathLockTest {
    static Object locka = new Object();
    static Object lockb = new Object();


    private static void deathLockTest() {
        synchronized (locka) {
            synchronized (lockb) {
                System.out.println("helloA");
            }
        }
    }

    private static void deathLock1Test() {
        synchronized (lockb) {
            synchronized (locka) {
                System.out.println("helloB");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            while (true) {
                deathLock1Test();
                deathLockTest();
            }
        });
        executorService.execute(() -> {
            while (true) {
                deathLock1Test();
                deathLockTest();
            }
        });
    }
}
