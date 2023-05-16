package com.designpattern.singleton;

public class LazySingletonUseVolatile {

    private static volatile LazySingletonUseVolatile singleton;

    private LazySingletonUseVolatile() {

    }

    public static LazySingletonUseVolatile getSingleton() {
        LazySingletonUseVolatile localSingleton = singleton;
        if (localSingleton == null) {
            synchronized (LazySingletonUseVolatile.class) {
                localSingleton = singleton;
                if (localSingleton == null) {
                    singleton = localSingleton = new LazySingletonUseVolatile();
                }
            }
        }
        return localSingleton;
    }


}

