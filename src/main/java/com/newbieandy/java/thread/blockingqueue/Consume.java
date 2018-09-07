package com.newbieandy.java.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consume implements Runnable {
    private final BlockingQueue<String> queue;

    public Consume(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("消费:" + queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
