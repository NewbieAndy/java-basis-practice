package com.newbieandy.java.thread;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {
    public static AtomicReference<User> userRef = new AtomicReference<User>();
    public static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
//        atomicReferenceTest();
        atomicFieldUpdate();
    }

    private static void atomicFieldUpdate() {
        User conan = new User("conan", 10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    private static void atomicReferenceTest() {
        User user = new User("andy", 22);
        userRef.set(user);
        User updateUser = new User("amy", 21);
        userRef.compareAndSet(user, updateUser);
        System.out.println(userRef.get().getName());
        System.out.println(userRef.get().getOld());

    }

    private static void atomicIntegerTest() {
        int[] value = new int[]{1, 2};
        AtomicIntegerArray array = new AtomicIntegerArray(value);
        array.getAndSet(0, 3);
        System.out.println(array.get(0));
        System.out.println(value[0]);
    }

    static class User {
        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return this.name;
        }

        public int getOld() {
            return this.old;
        }
    }
}
