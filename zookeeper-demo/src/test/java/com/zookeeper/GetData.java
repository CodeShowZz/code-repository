package com.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2020-10-06 上午12:45
 **/

public class GetData implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();


    @Test
    public void getDataSync() throws IOException, KeeperException, InterruptedException {
        String path = "/zk-book";
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new GetData());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        System.out.println("Zookeeper session established");
        zk.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(new String(zk.getData(path, true, stat)));
        System.out.println(stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());
        zk.setData(path, "123".getBytes(), -1);
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void getDataAsync() throws IOException, KeeperException, InterruptedException {
        String path = "/zk-book";
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new GetData());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        System.out.println("Zookeeper session established");
        zk.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zk.getData(path, true, new IDataCallback(), null);
        zk.setData(path, "123".getBytes(), -1);
        Thread.sleep(Integer.MAX_VALUE);
    }


    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                connectedSemaphore.countDown();
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                try {
                    System.out.println(new String(zk.getData(watchedEvent.getPath(), true, stat)));
                    System.out.println(stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());
                } catch (Exception e) {

                }
            }
        }
    }
}

class IDataCallback implements AsyncCallback.DataCallback {

    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        System.out.println(rc + ", " + path + ", " + new String(data));
        System.out.println(stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());
    }
}