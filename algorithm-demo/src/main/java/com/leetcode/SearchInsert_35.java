package com.leetcode;/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-19 13:10
 */
public class SearchInsert_35 {

    public static int searchInsert(int [] nums,int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                 left = mid + 1;
            } else {
                right = mid -1 ;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(SearchInsert_35.searchInsert(nums,7));

    }


}