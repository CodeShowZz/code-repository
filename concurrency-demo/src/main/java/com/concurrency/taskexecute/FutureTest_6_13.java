package com.concurrency.taskexecute;

import java.util.concurrent.*;

public class FutureTest_6_13 {
    private ExecutorService executor = Executors.newCachedThreadPool();


    public static void main(String[] args) throws ExecutionException {
        new FutureTest_6_13().testFuture();
    }

    public void testFuture() throws ExecutionException {

        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 1;
            }
        };
        Future<Integer> future = executor.submit(task);
        try {
            Integer result = future.get();
            System.out.println("result:" + result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            future.cancel(true);
        } catch (ExecutionException e) {
            throw e;
        }
    }

}
