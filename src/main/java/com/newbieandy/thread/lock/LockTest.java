package com.newbieandy.thread.lock;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    @Test
    public void testUseLock() {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock();
        try {
            //..
        } finally {
            lock.unlock();
        }
    }

    public boolean transferMoney(Account fromAcct, Account toAcct, DollarAmount amount, long timeout, TimeUnit unit) throws Exception {
        long fixedDelay = getFixedDelayComponentNanos(timeout, unit);
        long randMod = getRandomDelayModulusNanos(timeout, unit);
        long stopTime = System.nanoTime() + unit.toNanos(timeout);
        while (true) {
            if (fromAcct.lock.tryLock()) {
                try {
                    if (toAcct.lock.tryLock()) {
                        try {
                            if (fromAcct.getBalance().compareTo(amount) < 0) {
                                throw new Exception();
                            } else {
                                fromAcct.debit(amount);
                                toAcct.credit(amount);
                                return true;
                            }
                        } finally {
                            toAcct.lock.unlock();
                        }
                    }
                } finally {
                    fromAcct.lock.unlock();
                }
            }
            if (System.nanoTime() < stopTime) {
                return false;
            }
            TimeUnit.NANOSECONDS.sleep(fixedDelay + new Random().nextLong() % randMod);
        }
    }

    private long getRandomDelayModulusNanos(long timeout, TimeUnit unit) {
        return 0;
    }

    private long getFixedDelayComponentNanos(long timeout, TimeUnit unit) {
        return 0;
    }

    private class Account {
        public Lock lock;

        void debit(DollarAmount d) {

        }

        void credit(DollarAmount d) {

        }

        DollarAmount getBalance() {
            return null;
        }
    }

    private class DollarAmount implements Comparable<DollarAmount> {
        @Override
        public int compareTo(DollarAmount o) {
            return 0;
        }

        DollarAmount(int dollars) {

        }
    }

    Lock lock = new ReentrantLock();

    public boolean trySendOnSharedLine(String message, long timeout, TimeUnit unit) throws InterruptedException {
        long nanosToLock = unit.toNanos(timeout) - estimatedNanosToSend(message);
        if (!lock.tryLock(nanosToLock, TimeUnit.NANOSECONDS)) {
            return false;
        }
        try {
            return sendOnSharedLine(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean sendOnSharedLine(String message) {
        /* send something */
        return true;
    }

    long estimatedNanosToSend(String message) {
        return message.length();
    }

}
