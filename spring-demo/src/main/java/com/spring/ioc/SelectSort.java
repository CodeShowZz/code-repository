package com.spring.ioc;

import java.lang.reflect.Array;
import java.util.Arrays;


//剩余快速



public class SelectSort {


    public static void selectSort(int []nums) {
        int len = nums.length;
        for(int i =0 ;i <len; i++) {
            int min= i;
            for(int j = i+1;j<len;j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            if(min != i) {
                ArrayUtil.swap(nums,min,i);
            }
        }
    }

    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            for (int j = 1; j < len - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    ArrayUtil.swap(nums, j, j - 1);
                }
            }
    }

    public static void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    ArrayUtil.swap(nums, j, j - 1);
                }
            }
    }

    public static void shellSort(int[] nums) {
        int len = nums.length;
        int gap = len / 2;

        while (gap > 0) {

            for (int i = 0; i < len - 1; i++) {
                for (int j = i + gap; j < len && j - gap > 0; ) {
                    if (nums[j] < nums[j - gap]) {
                        ArrayUtil.swap(nums, j, j - gap);
                    } else {
                        break;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    public static void mergeArray(int[] nums, int start, int mid, int end,int [] temp) {
        int s = start;
        int m = mid + 1;
        int i = 0;
        while (s <= mid && m <= end) {
            if (nums[s] > nums[m]) {
                temp[i] = nums[m];
                m++;
                i++;
            } else {
                temp[i] = nums[s];
                s++;
                i++;
            }
        }
        while (s <= mid) {
            temp[i] = nums[s];
            s++;
            i++;
        }
        while (m <= end) {
            temp[i] = nums[m];
            m++;
            i++;
        }
        int x = 0;
       for(int j = start; j <= end;j++)  {
           nums[j] = temp[x];
           x++;
       }
    }

    public static void mergeSort(int [] nums,int start,int end,int[]temp) {
        if(start >=end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums,start,mid,temp);
        mergeSort(nums,mid+1,end,temp);
        mergeArray(nums,start,mid,end,temp);
    }

    public static void heapSort(int [] nums) {
        buildMaxHeap(nums);
        int len = nums.length;
        for(int i = 0; i < len;i ++) {
            ArrayUtil.swap(nums,0,len-i-1);
            heapify(nums,0,len-i-1);
        }
    }

    public static void buildMaxHeap(int [] nums){

        int len = nums.length;
        for(int i = len / 2 -1;i>=0;i--) {
            heapify(nums, i,len);
        }
    }


    public static void heapify(int [] nums,int i,int len) {
        int left = 2 * i  + 1;
        int right = 2 * i +2;
        int max = i;
        if(left < len && nums[left] > nums[max]) {
            max = left;
        }
        if(right < len && nums[right] > nums[max]) {
            max = right;
        }
        if(max != i)  {
            ArrayUtil.swap(nums,max,i);
            heapify(nums,max,len);
        }
    }

  public static  void quickSort(int []nums ,int start,int end) {
        if(start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int basic = nums[start];
        while(i < j) {
            while(i<j && basic <= nums[j]) {
                j--;
            }
            while(i<j && basic >= nums[i]) {
                i++;
            }
            if(i != j) {
                ArrayUtil.swap(nums,i,j);
            }
        }
        ArrayUtil.swap(nums,start,i);
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
  }



    public static void main(String[] args) {
        int [] nums = {8,321,9,2,32,42,3};
        int [] temp = new int[nums.length];
        quickSort(nums,0,6);
        System.out.println(Arrays.toString(nums));
    }

}
