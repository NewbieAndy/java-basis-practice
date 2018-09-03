package com.newbieandy.java.thread;

public class DeadLockTest {
    static Object lock1 = new Object();
    static Object lock2 = new Object();


    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello 1");
                synchronized (lock2) {
                    System.out.println("hello 1");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {
                    System.out.println("hello 2");
                }
            }
        }).start();
    }
}
