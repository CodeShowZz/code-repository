package com.javaconcurrencyinaction.task_execute;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class OutOfTime {

    public void outOfTime() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);
        TimeUnit.SECONDS.sleep(1);
        timer.schedule(new ThrowTask(),1);
        TimeUnit.SECONDS.sleep(5);
}

    static class ThrowTask extends TimerTask {
        public void run() {
            throw new RuntimeException();
        }
    }
}
