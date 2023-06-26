package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3 || nums[0] > 0) {
            return res;
        }
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l + 1] == nums[l]) {
                        l = l + 1;
                    }
                    while (l < r && nums[r - 1] == nums[r]) {
                        r = r - 1;
                    }
                    l = l + 1;
                    r = r - 1;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r = r - 1;
                } else {
                    l = l + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -1, 0};
        List<List<Integer>> res = new ThreeSum_15().threeSum(nums);
        System.out.println(res);
    }
}
