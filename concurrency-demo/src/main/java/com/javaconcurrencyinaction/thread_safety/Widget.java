package com.javaconcurrencyinaction.thread_safety;

/**
 * @author junlin_huang
 * @create 2020-10-19 下午9:39
 **/

public class Widget {

    public synchronized void doSomething() {

    }
}

class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}

