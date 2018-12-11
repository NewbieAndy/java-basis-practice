package com.newbieandy.java.ref;

/**
 * 引用对象测试
 */
public class RefTest {
    public static void main(String[] args) {
        ObjectA a = new ObjectA();
        a.setName("andy");
        System.out.println(a.getName());
        ObjectB b = new ObjectB(a);
        System.out.println(a.getName());
        b.test();
        System.out.println(a.getName());
    }
}
