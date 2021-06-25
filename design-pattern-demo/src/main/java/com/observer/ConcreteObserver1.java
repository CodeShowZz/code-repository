package com.observer;

/**
 * @author junlin_huang
 * @create 2021-06-25 7:19 PM
 **/

public class ConcreteObserver1 extends Observer{

    public ConcreteObserver1(String name,Notifier notifier) {
        super(name,notifier);
    }

    void update() {
        System.out.println("concrete observer1 receive:" + super.notifier.getAction());
    }

}