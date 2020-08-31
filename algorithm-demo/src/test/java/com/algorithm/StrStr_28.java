package com.algorithm;

import org.junit.Test;

/**
 * 力扣28 实现strStr
 * <p>
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author junlin_huang
 * @create 2020-08-26 上午3:37
 **/

public class StrStr_28 {

    @Test
    public void testStrStr() {
        System.out.println(strStr("aaa", "aaaa"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        } else if (haystack.equals("")) {
            return -1;
        }
        int needleLength = needle.length();
        char needleFirstChar = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needleFirstChar) {
                String temp = "";
                for (int j = 0; j < needleLength; j++) {
                    if (i + j >= haystack.length()) {
                        return -1;
                    }
                    temp = temp + haystack.charAt(i + j);
                }
                if (equal(temp, needle)) {
                    return i;
                }
            }
        }

        return -1;

    }

    public static boolean equal(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}