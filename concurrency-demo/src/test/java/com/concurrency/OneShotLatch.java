package com.concurrency;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class OneShotLatch {

    private class Sync extends AbstractQueuedSynchronizer {
        protected int tryAcquireShard(int ignored) {
            return getState() == 1 ? 1 : -1;
        }

        protected boolean tryReleaseShard(int ignored) {
            setState(1);
            return true;
        }
    }

    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }


}
