package com.newbieandy.java.interfacetest;

public class Test {
    public static void main(String[] args) {
        InterfaceA a = new ClassA();
        a.methodA();
        InterfaceA a1 = new ClassB();
        a1.methodA();
        InterfaceB b = new ClassB();
        b.methodA();
        b.methodB();
    }
}
