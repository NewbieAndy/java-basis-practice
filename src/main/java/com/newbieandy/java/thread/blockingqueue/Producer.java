package com.newbieandy.java.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 120; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                String s = name + "数量" + i;
                queue.put(s);
                System.out.println("生产:" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
