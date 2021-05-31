package com.javaconcurrencyinaction.threadpool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建固定大小线程池  采用有界队列以及调用者运行饱和策略
 *
 * @author junlin_huang
 * @create 2020-09-02 上午2:37
 **/

public class FixedThreadPoolUseBoundQueueAndCallerRunStrategy {
    @Test
    public void testFixedThreadPoolUseBoundQueueAndCallerRunStrategy() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(20));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }
}