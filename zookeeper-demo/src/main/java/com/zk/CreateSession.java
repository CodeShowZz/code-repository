package com.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2021-06-04 3:44 PM
 **/

public class CreateSession implements Watcher {

    //注意这里如果不加static的话 用的就不是同一个CountDownLatch对象 程序结束不了  具体原理还要再研究
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        new CreateSession().createSession();
    }

    public void createSession() throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 5000, new CreateSession());
        System.out.println(zooKeeper.getState());
        countDownLatch.await();
        System.out.println("zk session established");
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event" + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
    }
}