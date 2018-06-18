package com.newbieandy.java8.lambda;

public class InterfaceTest {
    public static void main(String[] args) {
        Flyable b = new Bird();
        b.fly();
        String name = b.getName();
        System.out.println(name);
        int count = Flyable.getLegCount();
        System.out.println(count);
    }
}
