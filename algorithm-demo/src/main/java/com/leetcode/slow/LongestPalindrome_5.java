package com.leetcode.slow;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-25 14:17
 */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        int[] max = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int[] odd = centerSpread(s, i, i);
            int[] even = centerSpread(s, i, i + 1);
            int[] tempMax = odd[1] > even[1] ? odd : even;
            max = tempMax[1] > max[1] ? tempMax : max;
        }
        return s.substring(max[0], max[0] + max[1]);
    }

    public int[] centerSpread(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - left - 1};
    }


    public String longestPalindrome2(String s) {
        int[] max = {0,0};
        for (int i = 0; i < s.length(); i++) {
            int[] even = centerSpread(i, i, s);
            int[] odd = centerSpread(i, i + 1, s);
            int []temp = even[1] > odd[1] ? even : odd;
            max = max[1] > temp[1] ? max : temp;
        }
        return s.substring(max[0],max[0] + max[1]);
    }

    public int[] centerSpread(int left, int right, String s) {
        while (left >= 0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left+1,right-left-1};
    }


    public static void main(String[] args) {
        String str = "babad";
        String max = new LongestPalindrome_5().longestPalindrome2(str);
        System.out.println(max);
    }
}