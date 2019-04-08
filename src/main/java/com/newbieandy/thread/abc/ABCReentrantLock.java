package com.newbieandy.thread.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程打印ABC 对象锁实现
 *
 * @author chao.ma
 * @Date 2019/4/8 17:38
 * @Version 1.0
 */
public class ABCReentrantLock {
    private static final Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static final int TOTAL_TIMES = 10;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(100);
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < TOTAL_TIMES; i++) {
                lock.lock();
                try {
                    System.out.print("A");
                    conditionB.signal();
                    if (i < TOTAL_TIMES - 1) {
                        conditionA.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < TOTAL_TIMES; i++) {
                lock.lock();
                try {
                    System.out.print("B");
                    conditionC.signal();
                    if (i < TOTAL_TIMES - 1) {
                        conditionB.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < TOTAL_TIMES; i++) {
                lock.lock();
                try {
                    System.out.print("C");
                    conditionA.signal();
                    if (i < TOTAL_TIMES - 1) {
                        conditionC.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
