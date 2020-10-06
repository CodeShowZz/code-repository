package com.zookeeper;

import org.apache.zookeeper.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2020-10-05 上午1:59
 **/

public class DeleteNode implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    @Test
    public void deleteNodeSync() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new DeleteNode());
        System.out.println(zooKeeper.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        System.out.println("Zookeeper session established");
        String path = "/zk-test";
        zooKeeper.create(path, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.delete(path,-1);
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if(Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath())
            connectedSemaphore.countDown();
        }
    }

}