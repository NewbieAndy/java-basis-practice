package com.newbieandy.executor;


import java.util.concurrent.*;

public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            completionService.submit(() -> {
                return finalI;
            });
        }

        for (int i = 4; i > 0; i--) {
            Future<Integer> take = completionService.take();
            System.out.println(take.get());
        }

    }
}
