package com.newbieandy.jvm;

public class ClassInitTest {
    static {
        i = 0;
//        System.out.println(i);
    }

    static int i = 1;

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "end");
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }
}

class Parent {
    public static int A = 1;

    static {
        A = 2;
    }
}

class Sub extends Parent {
    public static int B = A;
}

class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadloopClass");
            while (true) {

            }
        }
    }
}


