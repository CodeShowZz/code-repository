package com.leetcode;

import java.util.Arrays;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-05-09 15:54
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0;i<len;i++) {
            for(int j = i + 1;j < len;j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(nums,target)));
    }
}