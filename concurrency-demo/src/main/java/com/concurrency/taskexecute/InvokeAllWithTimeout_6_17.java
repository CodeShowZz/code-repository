package com.concurrency.taskexecute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class InvokeAllWithTimeout_6_17 {

    private ExecutorService executor = Executors.newCachedThreadPool();

    @Test
    public void testInvokeAllWithTimeout() throws InterruptedException, ExecutionException {
        int time = 3;
        List<Callable<Integer>> callableList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callableList.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(4 * 1000);
                    return 10;
                }
            });
        }
        List<Future<Integer>> futureList = executor.invokeAll(callableList, time, TimeUnit.SECONDS);
        for (Future<Integer> future : futureList) {
            try {
                Integer result = future.get();
                System.out.println("result:" + result);
            } catch (ExecutionException e) {
                throw e;
            }  catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                future.cancel(true);
            }  catch (CancellationException e) {
                System.out.println("cancel");
            }
        }

    }
}
