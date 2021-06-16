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

public class GetDataSync implements Watcher {

    //注意这里如果不加static的话 用的就不是同一个CountDownLatch对象 程序结束不了  具体原理还要再研究
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper = null;

    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        new GetDataSync().getData();
    }

    public static void getData() throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper("localhost:2181", 5000, new GetDataSync());
        countDownLatch.await();
        System.out.println("zk session established");

        String path = "/zk-book/cl";
        zooKeeper.create(path,"123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        System.out.println(new String(zooKeeper.getData(path,true,stat)));
        System.out.println(stat.getCzxid()+","+stat.getMzxid()+","+stat.getVersion());

        zooKeeper.setData(path,"123".getBytes(),-1);


        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                countDownLatch.countDown();
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                try {
                    System.out.println(new String(zooKeeper.getData(watchedEvent.getPath(),true,stat)));
                    System.out.println(stat.getCzxid()+","+stat.getMzxid()+","+stat.getVersion());
                } catch (Exception e) {

                }
            }
        }
    }
}