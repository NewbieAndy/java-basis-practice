package com.newbieandy.java8.lambda;

public class Java8LambdaTester {

    public static void main(String[] args) {
        MathOperation operation = (x, y) -> x + y;
        int operation1 = operation.operation(1, 3);
        System.out.println(operation1);
    }

    interface MathOperation {
        int operation(int a, int b);
    }
}
