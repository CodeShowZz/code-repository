package com.algorithm.leetcode;

import org.junit.Test;

/**
 * @author junlin_huang
 * @create 2020-09-20 下午4:24
 **/

public class MaxArea_11 {

    @Test
    public void testMaxArea() {
        int [] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    public int maxArea(int[] height) {
        int biggestArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int h = Math.min(height[i], height[j]);
                int area = width * h;
                if (area > biggestArea) {
                    biggestArea = area;
                }
            }
        }
        return biggestArea;
    }

}