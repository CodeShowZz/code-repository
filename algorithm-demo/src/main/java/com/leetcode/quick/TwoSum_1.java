package com.leetcode.quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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


    public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer,Integer> numToIndexMap = new HashMap<>();
        for(int i = 0;i< nums.length;i++) {
            if(numToIndexMap.containsKey(target - nums[i])) {
                int index = numToIndexMap.get(target-nums[i]);
                return new int[] {i,index};
            } else {
                numToIndexMap.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum_1().twoSum2(nums,target)));
    }
}