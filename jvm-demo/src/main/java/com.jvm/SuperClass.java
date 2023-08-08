package com.jvm;/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-07-24 20:23
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
/**
 * 非主动使用类字段演示
 **/
class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}

class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}