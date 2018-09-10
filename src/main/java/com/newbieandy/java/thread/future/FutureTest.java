package com.newbieandy.java.thread.future;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> future1 = new FutureTask<Integer>(() -> {
            System.out.println("future1");
            TimeUnit.SECONDS.sleep(1);
            return 1;
        });
        FutureTask<Integer> future2 = new FutureTask<Integer>(() -> {
            System.out.println("future2");
            TimeUnit.SECONDS.sleep(2);
            return 11;
        });
        FutureTask<Integer> future3 = new FutureTask<Integer>(() -> {
            System.out.println("future3");
            TimeUnit.SECONDS.sleep(3);
            return 111;
        });
        FutureTask<Integer> future4 = new FutureTask<Integer>(() -> {
            System.out.println("future4");
            TimeUnit.SECONDS.sleep(4);
            return 1111;
        });

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(future1);
        executorService.submit(future2);
        executorService.submit(future3);
        executorService.submit(future4);
        Integer int1 = future1.get();
        Integer int2 = future2.get();
        Integer int3 = future3.get();
        Integer int4 = future4.get();
        System.out.println(int1);
        System.out.println(int2);
        System.out.println(int3);
        System.out.println(int4);
        executorService.shutdown();
    }
}
