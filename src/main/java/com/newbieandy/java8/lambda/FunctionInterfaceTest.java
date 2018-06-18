package com.newbieandy.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class FunctionInterfaceTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0,11);
        //create thread
        Runnable r = ()-> System.out.println(Thread.currentThread().getName());
        new Thread(r).start();

        Consumer consumer = (x)-> System.out.println(x);
        consumer.accept(3);
        UnaryOperator operator = x->10;
        Object apply = operator.apply(1);
        System.out.println(apply);

    }

}
