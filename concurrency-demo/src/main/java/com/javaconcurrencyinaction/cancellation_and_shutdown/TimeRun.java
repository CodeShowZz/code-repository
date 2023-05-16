package com.javaconcurrencyinaction.cancellation_and_shutdown;

import java.util.concurrent.*;

public class TimeRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {

        } catch (ExecutionException e) {
            throw e;
        } finally {
            task.cancel(true);
        }
    }
}
