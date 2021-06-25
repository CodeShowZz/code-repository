package com.singleton;

/**
 * @author junlin_huang
 * @create 2021-06-25 6:13 PM
 **/

public class Singleton2 {

    private static Singleton2 singleton;

    private Singleton2() {

    }

    private Singleton2 getSingleton() {
        if(singleton ==null) {
            synchronized (Singleton2.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }

}