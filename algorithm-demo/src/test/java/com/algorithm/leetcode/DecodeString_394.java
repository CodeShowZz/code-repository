package com.algorithm.leetcode;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author junlin_huang
 * @create 2020-09-20 下午1:38
 **/

public class DecodeString_394 {

    int index = 0;

    @Test
    public void testDecodeString() {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public String decodeString(String s) {
        LinkedList<String> linkedList = new LinkedList<>();
        while (index < s.length()) {
            char ch = s.charAt(index);
            //有可能后面还是数字 所以出现了数字之后要判断到哪里数字结束
            if (Character.isDigit(ch)) {
                linkedList.addLast(getDigits(s));
            } else if (Character.isLetter(ch) || ch == '[') {
                linkedList.addLast(String.valueOf(ch));
                index++;
            } else {
                String temp = "";
                LinkedList<String> tempStack = new LinkedList<>();
                while (!linkedList.getLast().equals("[")) {
                    tempStack.add(linkedList.removeLast());
                }
                linkedList.removeLast();
                int number = Integer.parseInt(linkedList.removeLast());
                Collections.reverse(tempStack);
                String str = getString(tempStack);
                while (number > 0) {
                    temp = temp + str;
                    number--;
                }
                linkedList.addLast(temp);
                index++;
            }
        }
        return getString(linkedList);
    }

    public String getDigits(String str) {
        StringBuilder sb = new StringBuilder();
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                sb.append(str.charAt(index));
                index = index + 1;
            } else {
                break;
            }
        }
        return sb.toString();
    }


    public String getString(LinkedList<String> stack) {
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.removeFirst().toString());
        }
        return sb.toString();
    }


}