package hjl.util.concurrent.locks;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author junlin_huang
 * @create 2020-09-10 上午1:23
 **/

public class MyAbstractQueuedSynchronizer extends MyAbstractOwnableSynchronizer {

    private static final Unsafe unsafe;

    private static final long stateOffset;

    /**
     * 此处关于unsafe的获取(只不过是由于安全限制,变向获取Unsafe的一种方法)以及使用暂时当成黑盒
     */
    static {
        try {
            Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeInstance.setAccessible(true);
            unsafe = (Unsafe) theUnsafeInstance.get(Unsafe.class);
            stateOffset = unsafe.objectFieldOffset(MyAbstractQueuedSynchronizer.class.getDeclaredField("state"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private volatile int state;

    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    protected final void setState(int newState) {
        state = newState;
    }

    protected final int getState() {
        return state;
    }

    protected boolean tryRelease(int arg) {
        throw new UnsupportedOperationException();
    }

    public final boolean release(int arg) {
        if (tryRelease(arg)) {
            //TODO 源码中有该方法 暂时不知道有什么用
//            AbstractQueuedSynchronizer.Node h = head;
//            if (h != null && h.waitStatus != 0)
//                unparkSuccessor(h);
            return true;
        }
        return false;

    }


}