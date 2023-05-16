package com.designpattern.singleton;

public class LazySingletonNoUseDoubleCheck {

    private static LazySingletonNoUseDoubleCheck singleton;

    private LazySingletonNoUseDoubleCheck() {

    }

    public static synchronized LazySingletonNoUseDoubleCheck getSingleton() {
        if (singleton == null) {
            singleton = new LazySingletonNoUseDoubleCheck();
        }
        return singleton;
    }

}
