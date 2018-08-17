package com.newbieandy.java.thread.demo;

public class LockTest1 {

    private int i;

    public synchronized void setI(int i) {
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState() + "set I");
        this.i = i;
    }

    public synchronized int getI() {
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState() + "getI");
        return this.i;
    }

    public static void main(String[] args) {
        LockTest1 lockTest1 = new LockTest1();
        new Thread(() -> {
            while (true) {
                lockTest1.getI();
            }
        }).start();
        while (true) {
            lockTest1.setI(1);
        }
    }
}
