package com.newbieandy.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JconsoleTest {
    static class OOMObj {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        fillHeap(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        Object obj = new Object();
        createLockThread(obj);
    }

    private static void createBusyThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }, "testBusyThread").start();
    }

    private static void createLockThread(final Object lock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread").start();
    }

    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObj> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObj());
            System.gc();
        }
    }
}
