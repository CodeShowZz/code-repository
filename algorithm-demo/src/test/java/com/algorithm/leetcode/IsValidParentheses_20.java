package com.algorithm.leetcode;

import org.junit.Test;

import java.util.LinkedList;

/*
 * @author junlin_huang
 * @create 2020-08-25 上午12:30
 **/

public class IsValidParentheses_20 {

    @Test
    public void testIsValidParentheses() {
        System.out.println(isValidParentheses("([)]"));
    }


    public boolean isValidParentheses(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        LinkedList<Character> linkedList = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                linkedList.addFirst(ch);
            } else {
                if (linkedList.size() == 0) {
                    return false;
                }
                char matchCh = linkedList.removeFirst();
                if (ch == ')' && matchCh != '(') {
                    return false;
                } else if (ch == '}' && matchCh != '{') {
                    return false;
                } else if (ch == ']' && matchCh != '[') {
                    return false;
                }
            }
        }
        if (linkedList.size() == 0) {
            return true;
        }
        return false;
    }
}