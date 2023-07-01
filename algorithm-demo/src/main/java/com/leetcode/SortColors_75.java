package com.leetcode;

import com.util.ArrayUtil;

import java.util.Arrays;

public class SortColors_75 {

    public static void main(String[] args) {
        int [] nums = {2,0,1};
        new SortColors_75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }

        int len = nums.length;
        int zero = 0;
        int i = 0;
        int two = len;
        while(i < two) {
            if(nums[i] == 0) {
                //一旦遇到0,换到zero位置
                ArrayUtil.swap(nums,i,zero);
                //移动下一个存放0的位置
                zero++;
                i++;
            } else if(nums[i] == 1) {
                //如果是1的话,那么往前走,因为1会因为2和0的移动而放入中间
                i++;
            } else if(nums[i] == 2) {
                //移到下一个存放2的位置,不能先交换再移动,因为这样有可能再最后遇到2的时候,又可能交换到前面去
                two--;
                //一旦遇到2,换到two位置
                ArrayUtil.swap(nums,i,two);
                //i不变,因为可能交换过去的是个0,那么需要再判断一遍,如果是0,就需要把zero往右增大
            }
        }
    }
}
