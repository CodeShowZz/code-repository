package com.observer;

/**
 * @author junlin_huang
 * @create 2021-06-25 7:19 PM
 **/

public class ConcreteObserver2 extends Observer{

    public ConcreteObserver2(String name,Notifier notifier) {
        super(name,notifier);
    }

    void update() {
        System.out.println("concrete observer2 receive:" + super.notifier.getAction());
    }
}