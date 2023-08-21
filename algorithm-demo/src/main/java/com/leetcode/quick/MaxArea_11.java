package com.leetcode.quick;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-26 14:55
 */
public class MaxArea_11 {

    public int maxArea(int[] height) {
        int maxArea = 0;
        if(height == null || height.length < 2) {
            return maxArea;
        }
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int area = (right - left) * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,area);
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        int res = new MaxArea_11().maxArea2(height);
        System.out.println(res);
    }




    public int maxArea2(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int left = 0 ;
        int right = height.length-1;
        int max = 0;
        while(left < right) {
            int area = (right-left) * Math.min(height[left],height[right]);
            max = Math.max(area,max);
            if(height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;

    }








}