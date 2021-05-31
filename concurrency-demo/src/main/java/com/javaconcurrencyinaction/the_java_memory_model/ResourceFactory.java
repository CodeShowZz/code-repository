package com.javaconcurrencyinaction.the_java_memory_model;

public class ResourceFactory {

    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }

    static class Resource {
    }
}
