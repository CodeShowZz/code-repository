package com.leetcode.quick;/**
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
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
             if(sum < 0) {
                 sum = num;
             } else {
                 sum = sum + num;
             }
             max = Math.max(max,sum);
        }
        return max;
    }





    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = new MaxSubArray_53().maxSubArray(nums);
        System.out.println("sum:" + sum);
    }
}