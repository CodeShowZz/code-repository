package com.designpattern.singleton;

/**
 * @author junlin_huang
 * @create 2020-09-17 上午1:59
 **/

public class EagerSingleton {

    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getEagerSingleton() {
        return eagerSingleton;
    }

}