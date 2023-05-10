package com.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-05-09 16:14
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < len) {
            nums[j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes_283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}