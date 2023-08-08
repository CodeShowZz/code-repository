package com.javaconcurrencyinaction;/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-07-13 19:55
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);
        ThreadLocal threadLocal2 = new ThreadLocal();
//        threadLocal2.set(3);
        System.out.println(threadLocal.get());
        System.out.println(threadLocal2.get());
    }
}