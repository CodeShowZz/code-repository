package com.concurrency.taskexecute;

import org.junit.Test;

import java.util.concurrent.*;

public class CompletionServiceTest_6_15 {

    public static void main(String[] args) throws ExecutionException {
        new CompletionServiceTest_6_15().testCompletionService();
    }


    public void testCompletionService() throws ExecutionException {

        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService =
                new ExecutorCompletionService<Integer>(executor);
        int taskSize = 10;
        for (int i = 0; i < taskSize; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(3000);
                    return 1;
                }
            });
        }
        try {
            for (int i = 0; i < taskSize; i++) {
                Future<Integer> future = completionService.take();
                Integer result = future.get();
                System.out.println("result:" + result);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw e;
        }
    }

}
