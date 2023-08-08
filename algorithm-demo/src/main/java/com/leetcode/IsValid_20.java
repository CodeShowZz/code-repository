package com.leetcode;

import java.util.LinkedList;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-19 14:11
 */
public class IsValid_20 {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
             return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for(int i =0 ;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.addFirst(ch);
            } else {
                if(stack.size() == 0) {
                    return false;
                }
                char pop = stack.removeFirst();
                if(pop == '(' && ch != ')') {
                    return false;
                } else if(pop == '[' && ch != ']') {
                    return false;
                } else if(pop == '{' && ch != '}') {
                    return false;
                }
            }
        }
        if(stack.size() != 0) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
            String s = "]";
            System.out.println(new IsValid_20().isValid(s));
    }
}