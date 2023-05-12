package com.javaconcurrencyinaction.cancellation_and_shutdown;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeRun2 {

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

    public static void timeRun(final Runnable r, long timeout, TimeUnit unit) throws Throwable {

        class RethrowableTask implements Runnable {

            private Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void rethrow() throws Throwable {
                if (t != null) {
                    throw t;
                }
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();


    }
}
