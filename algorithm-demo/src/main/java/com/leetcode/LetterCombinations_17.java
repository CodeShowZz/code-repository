package com.leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-26 16:24
 */
public class LetterCombinations_17 {

    private HashMap<String, String> phoneMap = new HashMap();

    {
        phoneMap.put("1", "");
        phoneMap.put("2", "abc");
        phoneMap.put("3", "def");
        phoneMap.put("4", "ghi");
        phoneMap.put("5", "jkl");
        phoneMap.put("6", "mno");
        phoneMap.put("7", "pqrs");
        phoneMap.put("8", "tuv");
        phoneMap.put("9", "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(res, digits, sb, 0);
        return res;
    }

    private void dfs(List<String> res, String digits, StringBuilder sb, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String strs = phoneMap.get(String.valueOf(digits.charAt(index)));
        for (int i = 0; i < strs.length(); i++) {
            sb.append(strs.charAt(i));
            dfs(res, digits, sb, index + 1);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LetterCombinations_17().letterCombinations("");
        System.out.println("res:" + res);
    }
}