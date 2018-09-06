package com.newbieandy.jvm;

public class StackOOMTest {
    public static void main(String[] args) {
        StackOOMTest oomTest = new StackOOMTest();
        oomTest.stackLeakByThread();
    }

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                dontStop();
            }).start();
        }
    }
}
