package com.javaconcurrencyinaction.introduction;

/**
 * @author junlin_huang
 * @create 2020-10-18 下午11:43
 **/

public class Sequence {
    private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}