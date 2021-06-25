package com.observer;

/**
 * @author junlin_huang
 * @create 2021-06-25 7:04 PM
 **/

public abstract class Observer {

    protected String name;

    protected Notifier notifier;

    public Observer(String name,Notifier notifier) {
        this.name = name;
        this.notifier = notifier;
    }

    abstract void update();


}