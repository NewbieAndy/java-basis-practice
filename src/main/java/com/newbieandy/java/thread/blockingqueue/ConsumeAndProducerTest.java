package com.newbieandy.java.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ConsumeAndProducerTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(10);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(new Consume(queue));
        executorService.execute(new Consume(queue));
        executorService.execute(new Producer(queue));
        executorService.execute(new Producer(queue));
        executorService.execute(new Producer(queue));
        executorService.shutdown();
    }
}
