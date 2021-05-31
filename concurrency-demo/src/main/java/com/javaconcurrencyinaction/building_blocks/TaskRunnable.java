package com.javaconcurrencyinaction.building_blocks;

import java.util.concurrent.BlockingQueue;

/**
 * @author junlin_huang
 * @create 2020-10-21 上午1:49
 **/

public class TaskRunnable implements Runnable {

    BlockingQueue<Task> queue;

    @Override
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    void processTask(Task task) {

    }

    interface Task {

    }
}