package com.newbieandy.thread.communication;


/**
 * 等待唤醒机制
 */
public class Demo1 {
    private static int count = 0;
    private static final int MAX_COUNT = 100;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread producer1 = new Thread(new Producer(), "producer1");
        Thread consumer1 = new Thread(new Consumer(), "consumer1");
        Thread producer2 = new Thread(new Producer(), "producer2");
        Thread consumer2 = new Thread(new Consumer(), "consumer2");
        Thread producer3 = new Thread(new Producer(), "producer3");
        Thread consumer3 = new Thread(new Consumer(), "consumer3");
        Thread producer5 = new Thread(new Producer(), "producer5");
        Thread consumer4 = new Thread(new Consumer(), "consumer4");
        Thread consumer5 = new Thread(new Consumer(), "consumer5");
        Thread producer4 = new Thread(new Producer(), "producer4");
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            //生产10个
            for (int i = 0; i < MAX_COUNT; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock) {
                    while (count >= MAX_COUNT) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产1个，库存为:" + count);
                    lock.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX_COUNT; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock) {
                    while (count <= 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费1个，剩余库存:" + count);
                    lock.notifyAll();
                }
            }
        }
    }
}
