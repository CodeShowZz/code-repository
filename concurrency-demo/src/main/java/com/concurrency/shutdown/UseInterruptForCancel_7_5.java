package com.concurrency.shutdown;

import java.util.concurrent.TimeUnit;

/**
 * @author junlin_huang
 * @create 2020-10-15 上午12:50
 **/

public class UseInterruptForCancel_7_5 {

    public static void main(String[] args) throws InterruptedException {
        new UseInterruptForCancel_7_5().useInterruptForCancel();
    }

    public void useInterruptForCancel() throws InterruptedException {
        Thread t = new Thread(new BlockPrintTask());
        t.start();
        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
    }

    class BlockPrintTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("run");
                //模拟阻塞
                try {
                    TimeUnit.SECONDS.sleep(500);
                } catch (InterruptedException e) {
                    //重新设置中断状态 用于主动检测退出
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}