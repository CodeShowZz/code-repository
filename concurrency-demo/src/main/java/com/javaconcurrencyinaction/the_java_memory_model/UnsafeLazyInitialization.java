package com.javaconcurrencyinaction.the_java_memory_model;

/**
 * @author junlin_huang
 * @create 2020-10-19 上午8:58
 **/

public class UnsafeLazyInitialization {

    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null) {
            resource = new Resource();
        }
        return resource;
    }

    static class Resource {

    }
}