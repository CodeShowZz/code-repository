package com.algorithm;

import org.junit.Test;

/**
 * 力扣14 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * @author junlin_huang
 * @create 2020-08-24 下午11:32
 **/

public class LongestCommonPrefix_14 {

    @Test
    public void testLongestCommonPrefix() {
        String[] strs = {"abcde", "abcd", "abc"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String longestCommonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longestCommonPrefix = getLongestCommonPrefix(longestCommonPrefix, strs[i]);
            if (longestCommonPrefix.length() == 0) {
                break;
            }
        }
        return longestCommonPrefix;
    }

    public static String getLongestCommonPrefix(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return "";
        } else if (str1 == null && str2 != null) {
            return "";
        } else if (str1 != null && str2 == null) {
            return "";
        }
        int minLength = Math.min(str1.length(), str2.length());
        String longestCommonPrefix = "";
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                longestCommonPrefix = longestCommonPrefix + str1.charAt(i);
            } else {
                return longestCommonPrefix;
            }
        }
        return longestCommonPrefix;
    }


}