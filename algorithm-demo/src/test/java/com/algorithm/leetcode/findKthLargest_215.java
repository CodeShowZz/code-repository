package com.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author junlin_huang
 * @create 2020-09-20 下午1:20
 **/

public class findKthLargest_215 {

    @Test
    public void testFindKthLargest() {
        int[] nums = {1};
        System.out.println(findKthLargest(nums, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int record = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            record++;
            if (record == k) {
                return nums[i];
            }
        }
        return -1;
    }
}