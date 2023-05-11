package com.algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void mergeArray(int[] nums, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] >= nums[j]) {
                temp[k] = nums[j];
                j++;
                k++;
            } else {
                temp[k] = nums[i];
                i++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        k = 0;
        while(start <=end) {
            nums[start] = temp[k];
            start++;
            k++;
        }
    }

    public static void mergeSort(int []nums,int start,int end,int []temp) {
        if(start >= end) {
            return;
        }
        int mid =(start + end) / 2;
        mergeSort(nums,start,mid,temp);
        mergeSort(nums,mid +1,end,temp);
        mergeArray(nums,start,mid,end,temp);
    }

    public static void main(String[] args) {
        int nums[] = {321,423423,53534,34123123,12,3,4,5,2525,6};
        int [] temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
        System.out.println(Arrays.toString(temp));
    }
}
