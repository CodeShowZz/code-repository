package com.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author junlin_huang
 * @create 2021-06-04 3:44 PM
 **/

public class CreateNodeASync implements Watcher {

    //注意这里如果不加static的话 用的就不是同一个CountDownLatch对象 程序结束不了  具体原理还要再研究
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        new CreateNodeASync().createNode();
    }

    public void createNode() throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 5000, new CreateNodeASync());
        countDownLatch.await();
        System.out.println("zk session established");

        zooKeeper.create("/zk-test-ephemeral-","".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,new IStringCallback(),"I am context");

       zooKeeper.create("/zk-test-ephemeral-","".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,new IStringCallback(),"I am context");


       zooKeeper.create("/zk-test-ephemeral-","".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,new IStringCallback(),"I am context");
       Thread.sleep(10000);
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event" + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
    }

}

class IStringCallback implements AsyncCallback.StringCallback {

    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println("Create path result: [" + rc + ", " + path + ", "
                + ctx + ", real path name: " + name);
    }
}