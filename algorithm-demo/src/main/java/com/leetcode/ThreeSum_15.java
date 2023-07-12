package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        if(nums == null || nums.length <3) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0 ; i < nums.length ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i +1;
            int right = len -1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重
                    while(left < right && nums[left+1] == nums[left]) {
                        left++;
                    }
                    while(left<right && nums[right-1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> res = new ThreeSum_15().threeSum(nums);
        System.out.println(res);
    }
}
