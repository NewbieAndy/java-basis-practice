package com.newbieandy.java.thread;

/**
 * Created by mchao on 2017/6/28.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println("init state:" + thread.getState());
        Thread.sleep(1000);
        System.out.println("sleep state:" + thread.getState());
        System.out.println("init state:" + thread.getState());
        System.out.println("init state:" + thread.getState());

    }

    private static void test() {
        synchronized ("") {

        }
        System.out.println(Thread.currentThread().getName() + "start...");

        for (int i = 1; i <= 10; i++) {
            Thread tempThread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + "running... index->" + j);
                }
            });
            tempThread.setName("thread_" + i);
            tempThread.start();
            System.out.println(tempThread.getName() + "start..");
        }
        System.out.println(Thread.currentThread().getName() + "end...");
    }
}
