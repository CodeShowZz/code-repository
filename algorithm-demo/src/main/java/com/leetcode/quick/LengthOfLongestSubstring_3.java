package com.leetcode.quick;

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






















    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Map<Character,Integer> charMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            if(charMap.containsKey(ch)) {
                left = Math.max(left,charMap.get(ch)+1);
            }
            charMap.put(ch,i);
            maxLen = Math.max(maxLen,i - left +1);
        }
        return maxLen;
    }



    public static void main(String[] args) {
       int res =  new LengthOfLongestSubstring_3().lengthOfLongestSubstring2("abcabcbb");
       System.out.println("res:" + res);
    }
}