package com.newbieandy.thread.communicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition实现生产者消费者
 *
 * @author chao.ma
 * @Date 2019/4/8 14:43
 * @Version 1.0
 */
public class ConditionDemo {
    private static final Lock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();
    private static final int MAX_SIZE = 100;
    private static int count = 0;

    public static void main(String[] args) {
        Thread p1 = new Thread(new Producer(), "生产者1");
        Thread p2 = new Thread(new Producer(), "生产者2");
        Thread p3 = new Thread(new Producer(), "生产者3");
        Thread c1 = new Thread(new Consumer(), "消费者1");
        Thread c2 = new Thread(new Consumer(), "消费者2");
        Thread c3 = new Thread(new Consumer(), "消费者3");
        p1.start();
        c1.start();
        p2.start();
        c2.start();
        p3.start();
        c3.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < MAX_SIZE; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                try {
                    //判断条件
                    while (count == MAX_SIZE) {
                        notFull.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产1个,目前库存:" + count);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < MAX_SIZE; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();

                try {
                    while (count == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费一个,剩余库存:" + count);
                    notFull.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
