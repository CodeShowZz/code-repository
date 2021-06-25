package com.singleton;

/**
 * @author junlin_huang
 * @create 2021-06-25 6:19 PM
 **/

public class SingletonFactory {

    public Singleton3 getSingleton() {
        return SingletonHolder.singleton3;
    }

   private static class SingletonHolder {
      public static Singleton3 singleton3 = new Singleton3();
    }

    private static class Singleton3 {
       private Singleton3() {

       }
    }
}

