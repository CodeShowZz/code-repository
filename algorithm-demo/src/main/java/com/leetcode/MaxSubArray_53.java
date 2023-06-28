package com.leetcode;/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-28 18:03
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
         if(nums == null || nums.length == 0) {
             return 0;
         }
         if(nums.length == 1) {
             return nums[0];
         }
         int sum = nums[0];
         int max = sum;
         for(int i = 1;i<nums.length;i++) {
            if(sum < 0) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }
             max = Math.max(sum,max);
         }
       return max;
    }

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = new MaxSubArray_53().maxSubArray(nums);
        System.out.println("sum:" + sum);
    }
}