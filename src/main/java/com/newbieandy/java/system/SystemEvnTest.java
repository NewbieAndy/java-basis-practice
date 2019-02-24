package com.newbieandy.java.system;

public class SystemEvnTest {
    public static void main(String[] args) {
        String dir = System.getenv("MTIME_GLOBAL_CONFIG_PATH");
        System.out.println(dir);
    }
}
