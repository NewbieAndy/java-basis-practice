package com.newbieandy.jvm;

public class ExceptTest {
    public static final String b = "9";

    public int inc() {
        int i;
        try {
            i = 1;
            return i;
        } catch (Exception e) {
            i = 20;
            return i;
        } finally {
            i = 3;
        }
    }
}
