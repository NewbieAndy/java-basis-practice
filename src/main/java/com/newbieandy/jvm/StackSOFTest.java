package com.newbieandy.jvm;

public class StackSOFTest {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOFTest sofTest = new StackSOFTest();
        try {
            sofTest.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + sofTest.stackLength);
            throw e;
        }

    }

}
