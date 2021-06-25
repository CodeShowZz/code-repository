package com.singleton;

/**
 * @author junlin_huang
 * @create 2021-06-25 6:22 PM
 **/

public class Singleton4 {

    private Singleton4 singleton = new Singleton4();

    private Singleton4() {

    }

    public Singleton4 getSingleton() {
        return singleton;
    }
}