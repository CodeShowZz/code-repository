package com.algorithm;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 力扣20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1 左括号必须用相同类型的右括号闭合。
 * 2 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
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