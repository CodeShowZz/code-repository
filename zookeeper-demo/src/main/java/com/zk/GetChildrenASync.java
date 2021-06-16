package com.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2021-06-04 3:44 PM
 **/

public class GetChildrenASync implements Watcher {

    //注意这里如果不加static的话 用的就不是同一个CountDownLatch对象 程序结束不了  具体原理还要再研究
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper = null;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        new GetChildrenASync().getChildren();
    }

    public static void getChildren() throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper("localhost:2181", 5000, new GetChildrenASync());
        countDownLatch.await();
        System.out.println("zk session established");

        String path = "/zk-book";

        zooKeeper.create(path + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zooKeeper.getChildren(path, true,new IChildren2Callback(),null);

        zooKeeper.create(path + "/c2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                countDownLatch.countDown();
            } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                try {
                    System.out.println("Reget children:" + zooKeeper.getChildren(watchedEvent.getPath(), true));
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