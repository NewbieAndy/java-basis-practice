package com.newbieandy.java.thread.util;

import java.util.concurrent.*;

public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(() -> {
                    try {
                        System.out.println("before1");
                        TimeUnit.SECONDS.sleep(1);
                        cyclicBarrier.await();
                        System.out.println("after1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
        );
        executorService.execute(() -> {
                    try {
                        System.out.println("before2");
                        TimeUnit.SECONDS.sleep(1);
                        cyclicBarrier.await();
                        System.out.println("after2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
        );
        executorService.execute(() -> {
                    try {
                        System.out.println("before3");
                        TimeUnit.SECONDS.sleep(1);
                        cyclicBarrier.await();
                        System.out.println("after3");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
        );
        executorService.execute(() -> {
                    try {
                        System.out.println("before4");
                        TimeUnit.SECONDS.sleep(1);
                        cyclicBarrier.await();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("after4");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
        );

        System.out.println("the end");
        executorService.shutdown();
    }
}
