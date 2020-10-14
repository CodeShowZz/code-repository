package com.concurrency.shutdown;

import java.util.concurrent.TimeUnit;

/**
 * @author junlin_huang
 * @create 2020-10-14 下午11:49
 **/

public class UseVolatileFieldToHoldCancelState_7_1_7_2 {

    public static void main(String[] args) throws InterruptedException {
        new UseVolatileFieldToHoldCancelState_7_1_7_2().useVolatileFieldToHoldCancelState();
    }


    public void useVolatileFieldToHoldCancelState() throws InterruptedException {
        PrintTask printTask = new PrintTask();
        new Thread(printTask).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } finally {
            printTask.cancel();
        }
    }

    class PrintTask implements Runnable {

        private volatile boolean cancelled;

        @Override
        public void run() {
            while (!cancelled) {
                System.out.println("print...");
            }
        }

        public void cancel() {
            cancelled = true;
        }
    }
}

