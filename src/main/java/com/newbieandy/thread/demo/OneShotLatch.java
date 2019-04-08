package com.newbieandy.thread.demo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author chao.ma
 * @Date 2019/4/8 15:36
 * @Version 1.0
 */
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        protected int tryAcquireShard(int ignored) {
            //开 state==1,
            return getState() == 0 ? 1 : -1;
        }

        protected boolean tryReleaseShared(int ignored) {
            setState(1);
            return true;
        }
    }
}
