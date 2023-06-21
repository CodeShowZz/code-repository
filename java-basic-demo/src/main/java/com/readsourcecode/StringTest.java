package com.readsourcecode;

import org.openjdk.jol.vm.VM;

public class StringTest {

    public static void main(String[] args) {
        String s = "abc";
        String s1 = s + "def";
        String s2 = new String("abc");
        String s3 = new String("def");
        String s4 = "abcdef";
        String s5 = "abc";
        System.out.println(s == s2);
        System.out.println(s == s5);
        System.out.println(s1 == s4);

//        String str1 = new String("计算机").concat("软件");
//        System.out.println("Memory address: " + VM.current().addressOf(s1));
//        System.out.println("Memory address: " + VM.current().addressOf(s3));
//        System.out.println("Memory address: " + VM.current().addressOf(s4));
    }
}
