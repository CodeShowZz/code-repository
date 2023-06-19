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
        LinkedList<Character> linkedList = new LinkedList<>();
        for(int i = 0;i <s.length();i++) {
            char ch = s.charAt(i);
            if(ch == ')' || ch == ']' || ch == '}') {
                if(linkedList.size() == 0) {
                    return false;
                }
                char pop = linkedList.pop();
                if(ch == ')' && pop != '(') {
                    return false;
                }
                if(ch == ']' && pop != '[') {
                    return false;
                }
                if(ch == '}' && pop != '{') {
                    return false;
                }
            } else {
                linkedList.push(ch);
            }
        }
        if(linkedList.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
            String s = "]";
            System.out.println(new IsValid_20().isValid(s));
    }
}