package com.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2020-10-05 下午11:55
 **/

public class GetChildren implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static ZooKeeper zooKeeper;

    @Test
    public void getChildrenSync() throws IOException, KeeperException, InterruptedException {
        String path = "/zk-book";
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new GetChildren());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        System.out.println("Zookeeper session established");
        zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.create(path + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        List<String> childrenList = zooKeeper.getChildren(path, true);
        System.out.println(childrenList);

        zooKeeper.create(path + "/c2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void getChildrenAsync() throws KeeperException, InterruptedException, IOException {
        String path = "/zk-book";
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new GetChildren());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        System.out.println("Zookeeper session established");
        zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.create(path + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zooKeeper.getChildren(path, true, new IChildren2Callback(), null);
        zooKeeper.create(path + "/c2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                connectedSemaphore.countDown();
            } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                try {
                    System.out.println("ReGet Child:" + zooKeeper.getChildren(watchedEvent.getPath(), true));
                } catch (Exception e) {

                }
            }
        }
    }
}

class IChildren2Callback implements AsyncCallback.Children2Callback {

    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        System.out.println("Get Children znode result: [response code: " + rc + ", param path: " + path
                + ", ctx: " + ctx + ", children list: " + children + ", stat: " + stat);
    }
}