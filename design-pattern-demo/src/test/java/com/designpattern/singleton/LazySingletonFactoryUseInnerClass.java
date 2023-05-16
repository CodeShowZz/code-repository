package com.designpattern.singleton;

public class LazySingletonFactoryUseInnerClass {


    static class Singleton {
        private static Singleton singleton = new Singleton();

        private Singleton() {

        }
    }

    public static Singleton getSingleton() {
        return Singleton.singleton;
    }

}
