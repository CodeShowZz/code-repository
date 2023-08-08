package com.jvm;/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-07-24 20:26
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world";
}
/**
 * 非主动使用类字段演示
 **/
class NotInitialization3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
