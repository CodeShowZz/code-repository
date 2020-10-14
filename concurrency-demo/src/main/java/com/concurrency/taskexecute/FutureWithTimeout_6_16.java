package com.concurrency.taskexecute;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureWithTimeout_6_16 {

    private ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException {
        new FutureWithTimeout_6_16().testFutureWithTimeout();
    }

    public void testFutureWithTimeout() throws ExecutionException {
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 1;
            }
        });
        try {
            Integer result = future.get(1, TimeUnit.SECONDS);
            System.out.println("result:" + result);
        } catch (ExecutionException e) {
            throw e;
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("timeout");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            future.cancel(true);
        }
    }
}
