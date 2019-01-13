package com.newbieandy.java.thread.interrupte;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimedTest {
    private static final ScheduledExecutorService cancelExecutor = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        Future future = cancelExecutor.submit(() -> {

        });

        timedRun(() -> {
            while (true) {
                System.out.println(LocalDateTime.now());
            }
        }, 3, TimeUnit.SECONDS);
    }

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
        final Thread taskThread = Thread.currentThread();
        cancelExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        r.run();
    }

    public static void timedRun1(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class RethrowableTask implements Runnable {
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }
        }
    }
}
