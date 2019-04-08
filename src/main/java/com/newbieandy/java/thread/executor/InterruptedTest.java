package com.newbieandy.java.thread.executor;

public class InterruptedTest {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            System.out.println("中断前的状态:" + Thread.currentThread().isInterrupted());
            for (long i = 0; i < 10000000000L; i++) {

            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程被中断了...");
                System.out.println("中断清除前的状态:" + Thread.currentThread().isInterrupted());
                System.out.println("进行中断状态清除。。。");
                boolean interrupted = Thread.interrupted();
                System.out.println("中断状态清除结果:" + interrupted);

                boolean interrupted2 = Thread.interrupted();
                System.out.println("中断状态清除结果(2次):" + interrupted2);
                System.out.println("中断清除后的状态:" + Thread.currentThread().isInterrupted());
                System.out.println("进行中断状态恢复");
                Thread.currentThread().interrupt();
                System.out.println("进行中断状态恢复后的中断状态：" + Thread.currentThread().isInterrupted());
            }
            System.out.println("最终中断状态:" + Thread.currentThread().isInterrupted());
        });

        threadA.start();
        for (long i = 0; i < 5000000000L; i++) {

        }
        threadA.interrupt();
        //恢复中断

    }
}
