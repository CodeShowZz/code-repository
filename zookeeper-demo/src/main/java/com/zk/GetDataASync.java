package com.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2021-06-04 3:44 PM
 **/

public class GetDataASync implements Watcher {

    //注意这里如果不加static的话 用的就不是同一个CountDownLatch对象 程序结束不了  具体原理还要再研究
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper = null;

    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        new GetDataASync().getData();
    }

    public static void getData() throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper("localhost:2181", 5000, new GetDataASync());
        countDownLatch.await();
        System.out.println("zk session established");

        String path = "/zk-book/cl";
        zooKeeper.create(path,"123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        zooKeeper.getData(path,true,new IDataCallback(),null);
        zooKeeper.setData(path,"123".getBytes(),-1);

        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                countDownLatch.countDown();
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                try {
                    zooKeeper.getData(watchedEvent.getPath(),true,new IDataCallback(),null);
                } catch (Exception e) {

                }
            }
        }
    }
}

class IDataCallback implements AsyncCallback.DataCallback {

    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        System.out.println(rc + ", " + path + ", " + new String(data));
        System.out.println(stat.getCzxid()+","+
                stat.getMzxid()+","+
                stat.getVersion());
    }
}