package com.algorithm.leetcode;

import org.junit.Test;

import java.math.BigInteger;

/**
 * 1 如果出现数字之后 出现非数字字符 就结束
 * 2 如果没有数字 出现了 正负号和空格之外的字符 则返回0
 * 3 如果出现了一个正号或负号 后面只能跟数字 否则返回0
 *
 * @author junlin_huang
 * @create 2020-09-19 下午8:24
 **/
public class MyAtoi_8 {

    @Test
    public void testMyAtoi() {
        System.out.println(myAtoi("42"));
    }

    public int myAtoi(String str) {
        boolean hasDigit = false;
        boolean hasSign = false;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hasDigit && !isDigit(ch)) {
                break;
            }
            if (!hasDigit && (ch != ' ' && ch != '+' && ch != '-' && !isDigit(ch))) {
                return 0;
            }
            if (hasSign && !isDigit(ch)) {
                return 0;
            }
            if (ch == ' ') {

            } else if (isDigit(ch)) {
                result = result + ch;
                hasDigit = true;
            } else if (ch == '+' || ch == '-') {
                result = result + ch;
                hasSign = true;
            }
        }
        if (result.equals("") || result.equals("+") || result.equals("-")) {
            return 0;
        }
        BigInteger bigInteger = new BigInteger(result);
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == 1) {
            return Integer.MAX_VALUE;
        } else if (bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) == -1) {
            return Integer.MIN_VALUE;
        } else {
            return bigInteger.intValue();
        }

    }


    public boolean isDigit(char ch) {
        return ch <= '9' && ch >= '0';
    }

}