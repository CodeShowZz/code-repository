package com.javaconcurrencyinaction.cancellation_and_shutdown;

import java.util.concurrent.BlockingQueue;

public class NoncancelabnleTask {

    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }


    interface Task {

    }
}
