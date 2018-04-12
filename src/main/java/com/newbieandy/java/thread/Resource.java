package com.newbieandy.java.thread;

import java.util.ArrayList;

/**
 * 线程通宵-资源库 Created by mchao on 2018/1/2.
 */
public class Resource {
    private static final int RES_LENGTH = 5;
    private ArrayList<Integer> res = new ArrayList<>(RES_LENGTH);
    private int count=0;

    /**
     * 添加
     */
    public synchronized void push() {
        if (res.size() <= 5) {
            count++;
            System.out.println("添加资源"+count);
            res.add(count);
        }
    }

    /**
     * 删除
     */
    public synchronized void pull() {
        if (res.size()>0){
            System.out.println("删除资源"+res.get(0));
            res.remove(0);
        }
    }
}
