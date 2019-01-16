package com.newbieandy.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExceptionTest {
    static class ExceptionThread implements Runnable {

        @Override
        public void run() {
            throw new RuntimeException();
        }

        public static void main(String[] args) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        }
    }

    static class ExceptionThread2 implements Runnable {

        @Override
        public void run() {
            Thread t = Thread.currentThread();
            System.out.println("run() by " + t);
            System.out.println("eh = " + t.getUncaughtExceptionHandler());
            throw new RuntimeException();
        }
    }

    static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("caught " + e);
        }
    }

    static class HandlerThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            System.out.println(this + " creating new Thread");
            Thread t = new Thread(r);
            System.out.println("created " + t);
            t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            System.out.println("eh = " + t.getUncaughtExceptionHandler());
            return t;
        }

    }

    static class CaptureUncaughtException {
        public static void main(String[] args) {
            ExecutorService exe = Executors.newCachedThreadPool(new HandlerThreadFactory());
            exe.execute(new ExceptionThread2());
        }
    }
}
