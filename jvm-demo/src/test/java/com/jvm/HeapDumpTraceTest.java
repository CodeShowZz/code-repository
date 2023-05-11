package com.jvm;

import org.junit.Test;

import java.util.Map;

public class HeapDumpTraceTest {

    @Test
    public void heapDumpTraceTest() {
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stack = stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            System.out.println("线程:" + thread.getName());
            for (StackTraceElement trace : stack) {
                System.out.println(trace);
            }

        }
    }

    @Test
    public void myTest() {
        System.out.println("32");
        Thread thread = new Thread();
    }
}
