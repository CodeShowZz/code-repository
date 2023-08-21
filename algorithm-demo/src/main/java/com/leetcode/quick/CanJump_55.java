package com.leetcode.quick;

public class CanJump_55 {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int max = 0;
        for(int i = 0 ; i < nums.length;i++) {
            if(max < i) {
                return false;
            }
            max = Math.max(max,nums[i] + i);
        }
        return true;
    }





    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int max = 0;
        for(int i = 0;i<nums.length;i++) {
            if(max < i) {
                return false;
            }
            max = Math.max(max,nums[i]+i);
        }
        return true;
    }















}
