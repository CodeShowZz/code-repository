package com.zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;

// ZooKeeper API 删除节点，使用同步(sync)接口。
public class DeleteNodeSync implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk;

    public static void main(String[] args) throws Exception {
        deleteNodeSync();
    }

    public static void deleteNodeSync() throws IOException, KeeperException, InterruptedException {
        String path = "/zk-book/c1";
        zk = new ZooKeeper("localhost:2181",
                5000, //
                new DeleteNodeSync());
        connectedSemaphore.await();

        zk.create(path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.delete(path, -1);

        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent event) {
        if (KeeperState.SyncConnected == event.getState()) {
            if (EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            }
        }
    }
}