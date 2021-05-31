package com.javaconcurrencyinaction.introduction;

/**
 * @author junlin_huang
 * @create 2020-10-18 下午11:36
 **/

public class UnsafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }

}