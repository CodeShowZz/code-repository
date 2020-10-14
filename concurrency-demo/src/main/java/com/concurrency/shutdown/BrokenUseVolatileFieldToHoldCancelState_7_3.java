package com.concurrency.shutdown;

import java.util.concurrent.TimeUnit;

/**
 * 如果一直无法检测取消状态 也就是任务被阻塞住了 那么就可能出现线程无法停止的情况
 *
 * @author junlin_huang
 * @create 2020-10-15 上午12:18
 **/

public class BrokenUseVolatileFieldToHoldCancelState_7_3 {

    public static void main(String[] args) throws InterruptedException {
        new BrokenUseVolatileFieldToHoldCancelState_7_3().brokenUseVolatileFieldToHoldCancelState();
    }


    public void brokenUseVolatileFieldToHoldCancelState() throws InterruptedException {
        BlockPrintTask blockPrintTask = new BlockPrintTask();
        new Thread(blockPrintTask).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } finally {
            blockPrintTask.cancel();
        }
    }

    class BlockPrintTask implements Runnable {

        private volatile boolean cancelled;

        @Override
        public void run() {
            while (!cancelled) {
                System.out.println("run");
                //模拟阻塞 无法检查取消信号
                try {
                    TimeUnit.SECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void cancel() {
            cancelled = true;
        }
    }

}
