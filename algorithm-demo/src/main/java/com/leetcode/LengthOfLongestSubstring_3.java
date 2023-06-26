package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-25 10:02
 */
public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(positionMap.containsKey(ch)) {
                left = Math.max(left,positionMap.get(ch) + 1);
            }
            positionMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
       int res =  new LengthOfLongestSubstring_3().lengthOfLongestSubstring("pwwkew");
       System.out.println("res:" + res);
    }
}