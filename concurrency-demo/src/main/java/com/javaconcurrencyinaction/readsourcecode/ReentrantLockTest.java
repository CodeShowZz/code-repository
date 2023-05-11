package com.javaconcurrencyinaction.readsourcecode;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-05-10 9:12
 */
public class ReentrantLockTest {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Work w1 = new Work(lock);
        Work w2 = new Work(lock);
        new Thread(w1).start();
        new Thread(w2).start();
    }

}

class Work implements Runnable {

    private ReentrantLock lock;

    public Work(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while(true) {
            try {
                lock.lock();
                System.out.println(name + " get lock");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + " release lock");
                lock.unlock();
            }
        }
    }
}