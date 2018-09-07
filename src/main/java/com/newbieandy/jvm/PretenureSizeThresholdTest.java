package com.newbieandy.jvm;

public class PretenureSizeThresholdTest {
    private static final int m = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * m];
    }
}
