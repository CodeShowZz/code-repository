package com.javaconcurrencyinaction.the_java_memory_model;

import java.util.HashMap;
import java.util.Map;

public class SafeStates {

    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<>();
        states.put("alaska", "AK");
        states.put("alabama", "AL");
        /*...*/
        states.put("wyoming", "WY");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
