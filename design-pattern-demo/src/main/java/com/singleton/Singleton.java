package com.singleton;

/**
 * @author junlin_huang
 * @create 2021-06-25 6:13 PM
 **/

public class Singleton {

    private static Singleton singleton;

    private Singleton() {

    }

    private Singleton getSingleton() {
        synchronized (Singleton.class) {
            if(singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

}