package com.newbieandy.jvm;

/**
 * jvm  -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class AllocationTest {
    private static final int m = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * m];
        allocation2 = new byte[2 * m];
        allocation3 = new byte[2 * m];
        allocation4 = new byte[4 * m];
    }
}
