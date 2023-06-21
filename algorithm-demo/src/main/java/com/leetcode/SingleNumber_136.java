package com.leetcode;

public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0 ;i < nums.length ;i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {4,1,2,1,2};
        System.out.println(new SingleNumber_136().singleNumber(nums));
    }
}
