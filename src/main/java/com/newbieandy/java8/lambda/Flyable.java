package com.newbieandy.java8.lambda;

/**
 * java8 interface test
 */
public interface Flyable {
    void fly();

    default String getName(){
        return "bird";
    }

    static int getLegCount(){
        return 2;
    }
}
