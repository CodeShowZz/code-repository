package com.leetcode;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-26 14:55
 */
public class MaxArea_11 {

    public int maxArea(int[] height) {
        if(height == null || height.length == 1) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <right) {
            int area = (right - left) * Math.min(height[left],height[right]);
            maxArea = Math.max(area,maxArea);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        int res = new MaxArea_11().maxArea(height);
        System.out.println(res);
    }
}