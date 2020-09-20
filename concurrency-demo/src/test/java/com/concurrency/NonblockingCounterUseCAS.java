package com.concurrency;

public class NonblockingCounterUseCAS {


    private SimulatedCASByLock value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }

}
