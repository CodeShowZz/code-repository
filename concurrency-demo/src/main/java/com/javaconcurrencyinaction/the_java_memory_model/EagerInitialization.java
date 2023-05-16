package com.javaconcurrencyinaction.the_java_memory_model;

public class EagerInitialization {

    private static Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {
    }
}
