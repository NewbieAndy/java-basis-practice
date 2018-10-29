package com.newbieandy.java.ref;

public class ObjectB {
    private ObjectA objectA;

    public ObjectB(ObjectA objectA) {
        this.objectA = objectA;
    }

    public void test() {
        System.out.println(objectA.getName());
        objectA.setName("Amy");
    }
}
