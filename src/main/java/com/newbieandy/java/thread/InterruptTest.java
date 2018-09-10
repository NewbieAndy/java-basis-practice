package com.newbieandy.java.thread;

import java.util.concurrent.TimeUnit;

public class InterruptTest {
    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            System.out.println("Worker started");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("Worker isInterrupted:" + Thread.currentThread().isInterrupted());
                boolean interrupted = Thread.interrupted();
                System.out.println("14:" + interrupted);
            }
            System.out.println("Worker stopped");
            System.out.println("Worker isInterrupted:" + Thread.currentThread().isInterrupted());
        });

        threadA.start();
        threadA.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Main thread stopped");
    }
}
