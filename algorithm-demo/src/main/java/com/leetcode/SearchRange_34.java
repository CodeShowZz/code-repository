package com.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-27 11:59
 */
public class SearchRange_34 {

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int [] res = new SearchRange_34().searchRange(nums,8);
        System.out.println("res:" + Arrays.toString(res));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int first = searchFirst(nums,target);
        int last = searchLast(nums,target);
        return new int[]{first,last};
    }

    public int searchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != nums[mid] ) {
                    return mid;
                }
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int searchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1  || nums[mid +1] != nums[mid]) {
                    return mid;
                }
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}