package com.newbieandy.thread.demo;

/**
 * @author chao.ma
 * @Date 2019/4/8 11:18
 * @Version 1.0
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundeBuffer<V> {
    protected GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }
}
