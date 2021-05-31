package com.javaconcurrencyinaction;

import org.junit.Test;
import java.util.concurrent.CountDownLatch;

/**
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * <p>
 * 示例 2:
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 * <p>
 */
public class OrderPrint {

    @Test
    public void testOrderPrint() throws InterruptedException {
        OrderPrint orderPrint = new OrderPrint();
        new Thread(() ->
        {
            try {
                orderPrint.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try {
                orderPrint.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try {
                orderPrint.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while(true){

        }
    }


    private CountDownLatch firstCountDownLatch = new CountDownLatch(1);
    private CountDownLatch secondCountDownLatch = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstCountDownLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        firstCountDownLatch.await();
        printSecond.run();
        secondCountDownLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        secondCountDownLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

