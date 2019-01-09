package com.newbieandy.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> taskList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            taskList.add(() -> {
                if (finalI % 2 == 0) {
                    throw new RuntimeException("x%2==0");
                }
                if (finalI % 3 == 0) {
                    TimeUnit.SECONDS.sleep(4);
                }
                return finalI;
            });
        }
        List<Future<Integer>> futures = executorService.invokeAll(taskList, 2, TimeUnit.SECONDS);
        futures.forEach(future -> {
            try {
                Integer integer = future.get();
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.out.println(e.getCause());
            } catch (CancellationException e) {
                System.out.println(e);
            }

        });
    }
}
