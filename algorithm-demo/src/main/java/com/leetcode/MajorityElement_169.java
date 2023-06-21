package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int targetCount = len / 2 ;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i],1);
            }
        }
        for(int i = 0;i<nums.length;i++) {
            if(hashMap.get(nums[i]) > targetCount) {
                return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
       int res = new MajorityElement_169().majorityElement(nums);
       System.out.println("res:" + res);
    }

}
