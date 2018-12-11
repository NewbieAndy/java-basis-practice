package com.newbieandy.java.finaltest;

public class FinalTest {
    public static void main(String[] args) {
        final int a;
        final MutableObj b = new MutableObj("andy");
        a = 12;
        System.out.println("a:" + a);
        b.desc = "asdf";
        System.out.println(b);
    }
}
