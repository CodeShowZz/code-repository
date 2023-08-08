package com.leetcode;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-27 11:29
 */
public class Search_33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] < nums[mid]) {
                if (target < nums[mid] && nums[mid] >= nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }






















    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] < nums[mid]) {
                //左边有序
                if (target < nums[mid] && target >= nums[0]) {
                    //在左边
                    hi = mid - 1;
                }
                {
                    //在右边
                    lo = mid + 1;
                }
            } else {
                //右边有序
                if (target > nums[mid] && target <= nums[len - 1]) {
                    //在右边
                    lo = mid + 1;
                } else {
                    //在左边
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {3,1};
        int res = new Search_33().search2(nums,1);
        System.out.println("res:" + res);
    }
}