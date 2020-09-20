package com.algorithm.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author junlin_huang
 * @create 2020-09-18 上午1:50
 **/

public class ThreeSum_15 {


    @Test
    public void testThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4}; // {-4,-1,-1,0,1,2}
        List<List<Integer>> result = threeSum(nums);
        System.out.print(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1) {
                    if (nums[j] == nums[j - 1]) {
                        continue;
                    }
                }
                int target = 0 - nums[i] - nums[j];
                int k = nums.length - 1;
                while (j < k && nums[k] > target) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[k] == target) {
                    List<Integer> single = new ArrayList<>();
                    single.add(nums[i]);
                    single.add(nums[j]);
                    single.add(nums[k]);
                    result.add(single);
                }
            }
        }
        return result;
    }


}