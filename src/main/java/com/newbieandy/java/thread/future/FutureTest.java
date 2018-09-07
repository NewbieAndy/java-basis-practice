package com.newbieandy.java.thread.future;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> future = new FutureTask<Integer>(() -> {

            System.out.println("future");
            TimeUnit.SECONDS.sleep(2);
            return 1;
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(future);
        Integer i = future.get();
        System.out.println(i);
    }
}
