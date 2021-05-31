package com.javaconcurrencyinaction;

import org.junit.Test;

/**
 * 有两个线程，线程A只输出1，线程B只输出2，写程序输出121212.
 */
public class TwoThreadAlternatePrint {

    private volatile int x = 1;

    @Test
    public void testTwoThreadAlternatePrint() {
        Object lock = new Object();
        new Thread(new FirstTask(lock)).start();
        new Thread(new SecondTask(lock)).start();
        while (true) {

        }
    }

    class FirstTask implements Runnable {

        private Object lock;

        public FirstTask(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        if (x != 1) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1");
                    x = 2;
                    lock.notify();
                }
            }
        }
    }

    class SecondTask implements Runnable {

        private Object lock;

        public SecondTask(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        if (x != 2) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2");
                    x = 1;
                    lock.notify();
                }
            }
        }
    }
}

