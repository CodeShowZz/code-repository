package com.algorithm;

import com.util.ArrayUtil;

import java.util.Arrays;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-08 12:49
 */
public class QuickSort2 {

    public static void quickSort(int [] arr,int low,int high) {
        if(low < high) {
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }

    public static int partition(int [] arr,int low,int high) {
        int i = low - 1;
        int pivot = arr[high];
        for(int j = low;j < high;j++) {
            if(arr[j] < pivot) {
                i = i + 1;
                ArrayUtil.swap(arr,i,j);
            }
        }
        ArrayUtil.swap(arr,i+1,high);
        return i +1;
    }

    public static void main(String args[]) {

        int[] data = { 8, 7, 2, 1, 0, 9, 6 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;

        // call quicksort() on array data
        QuickSort2.quickSort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}