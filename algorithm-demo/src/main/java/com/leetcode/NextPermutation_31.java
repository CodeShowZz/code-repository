package com.leetcode;

import com.util.ArrayUtil;

import java.util.Arrays;

public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int j = 0;
        int t = 0;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                j = i;
                t = j-1;
                break;
            }
        }
        for (int k = len - 1; k >= j; k--) {
            if (nums[k] > nums[t]) {
                swap(nums, t, k);
                break;
            }
        }
        Arrays.sort(nums, j , len);
    }

    public static void swap(int [] nums,int i ,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        new NextPermutation_31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
