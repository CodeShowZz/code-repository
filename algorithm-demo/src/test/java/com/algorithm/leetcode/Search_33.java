package com.algorithm.leetcode;

import org.junit.Test;

/**
 * [4,5,6,7,0,1,2] )
 */
public class Search_33 {

    @Test
    public void tesetSearch() {
        int nums[] = {3, 1};
        System.out.println(search(nums, 1));
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1 && nums[0] == target) {
            return 0;
        }
        int l = 0;
        int r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (l == mid) {
                l = mid + 1;
            } else if (r == mid) {
                r = mid - 1;
            } else if (nums[l] < nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
