package com.observer;

import java.util.List;

/**
 * @author junlin_huang
 * @create 2021-06-25 7:05 PM
 **/

public abstract class Notifier {

    private String name;

    private String action;

    private List<Observer> observerList;

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void inform() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction() {
        this.action = action;
    }

}