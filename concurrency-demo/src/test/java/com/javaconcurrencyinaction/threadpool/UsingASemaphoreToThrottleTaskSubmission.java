package com.javaconcurrencyinaction.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 使用信号量控制任务提交
 *
 * @author junlin_huang
 * @create 2020-09-02 上午2:47
 **/

public class UsingASemaphoreToThrottleTaskSubmission {

    private final Executor exec;

    private final Semaphore semaphore;

    public UsingASemaphoreToThrottleTaskSubmission(Executor executor, Semaphore semaphore) {
        this.exec = executor;
        this.semaphore = semaphore;
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }
}