package com.javaconcurrencyinaction.the_java_memory_model;

public class SafeLazyInitialization {

    private static Resource resource;

    public synchronized static Resource getInstance() {
        if (resource == null) {
            resource = new Resource();
        }
        return resource;
    }

    static class Resource {

    }

}
