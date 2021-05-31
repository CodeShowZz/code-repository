package com.javaconcurrencyinaction.thread_safety;

public class LazyInitRace {


    private ExpensiveObject instance = null;

    private ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

}


class ExpensiveObject {

}
