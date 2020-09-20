package hjl.util.concurrent.locks;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @author junlin_huang
 * @create 2020-09-10 上午1:16
 **/

public class MyReenTrantLock {

    private final Sync sync;

    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    public boolean unlock() {
        return sync.release(1);
    }

    public MyReenTrantLock() {
        sync = new MyReenTrantLock.NonfairSync();
    }

    abstract static class Sync extends MyAbstractQueuedSynchronizer {
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }

    }

    static final class NonfairSync extends Sync {

    }
}