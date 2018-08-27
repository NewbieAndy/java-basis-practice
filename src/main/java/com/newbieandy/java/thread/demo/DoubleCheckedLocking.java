package com.newbieandy.java.thread.demo;

import com.newbieandy.java.reflect.bean.Person;

public class DoubleCheckedLocking {
    private volatile static Person person;

    //双检锁
    public static Person getInstance() {
        //第一次检查:4
        if (null == person) {
            //加锁 :5
            synchronized (DoubleCheckedLocking.class) {
                //第二次检查:6
                if (null == person) {
                    //初始化对象:7
                    person = new Person();
                }
            }
        }
        return person;
    }
}
