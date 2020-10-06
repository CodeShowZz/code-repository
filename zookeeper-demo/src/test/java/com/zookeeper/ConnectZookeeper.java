package com.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2020-10-05 上午1:03
 **/

public class ConnectZookeeper implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    @Test
    public void connectZookeeperSimple() throws IOException {

        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ConnectZookeeper());
        System.out.println(zooKeeper.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        System.out.println("Zookeeper session established");
    }

    @Test
    public void connectZookeeperReuseSession() throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ConnectZookeeper());
        System.out.println(zooKeeper.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        long sessionId = zooKeeper.getSessionId();
        byte [] passwd = zooKeeper.getSessionPasswd();
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ConnectZookeeper(),sessionId,passwd);
        Thread.sleep(Integer.MAX_VALUE);

    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            connectedSemaphore.countDown();
        }
}
}