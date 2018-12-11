package com.newbieandy.java.interfacetest;

public class ClassB implements InterfaceB {
    @Override
    public void methodB() {
        System.out.println("ClassB methodB");
    }

    @Override
    public void methodA() {
        System.out.println("ClassB methodA");
    }
}
