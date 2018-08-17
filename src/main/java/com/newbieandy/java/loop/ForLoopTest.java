package com.newbieandy.java.loop;

public class ForLoopTest {
    public static void main(String[] args) {
        int i = 10;

        for (; i > 1 && i > 4; i /= 2) {
            System.out.println(i);
        }
        System.out.println("final:" + i);
    }
}
