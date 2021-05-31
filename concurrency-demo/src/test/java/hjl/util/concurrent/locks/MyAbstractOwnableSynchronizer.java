package hjl.util.concurrent.locks;

/**
 * @author junlin_huang
 * @create 2020-09-10 上午1:42
 **/

public class MyAbstractOwnableSynchronizer {

    private transient Thread exclusiveOwnerThread;

    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    public static void main(String[] args) {
       int byteSize =  134217728;
       System.out.println(byteSize / 1024 / 1024 );
    }
}