package com.newbieandy.thread.test;

import org.junit.Assert;
import org.junit.Test;

public class BoundedBufferTest {
    @Test
    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        Assert.assertTrue(bb.isEmpty());
        Assert.assertFalse(bb.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }
        Assert.assertTrue(bb.isFull());
        Assert.assertFalse(bb.isEmpty());
    }

    @Test
    public void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        Thread taker = new Thread(() -> {
            try {
                int unused = bb.take();
                Assert.fail();
            } catch (InterruptedException e) {
            }

        });
        try {
            taker.start();
            Thread.sleep(10000);
            taker.interrupt();
            taker.join(10000);
            Assert.assertFalse(taker.isAlive());
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
