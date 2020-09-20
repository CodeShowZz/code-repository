package com.algorithm.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author junlin_huang
 * @create 2020-09-18 上午12:21
 **/

public class LengthOfLongestSubstring_3 {

    @Test
    public void testLengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring(s, i), lengthOfLongestSubstring);
        }
        return lengthOfLongestSubstring;
    }


    public int lengthOfLongestSubstring(String s, int i) {
        int tempLengthOfLongestSubstring = 0;
        Set<Character> characterSet = new HashSet<>();
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!characterSet.add(ch)) {
                return tempLengthOfLongestSubstring;
            } else {
                tempLengthOfLongestSubstring++;
            }
            i++;
        }
        return tempLengthOfLongestSubstring;
    }
}