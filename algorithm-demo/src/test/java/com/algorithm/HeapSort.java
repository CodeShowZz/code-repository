package com.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序(暂时没理解代码为什么这么写)
 *
 * @author junlin_huang
 * @create 2020-08-30 上午3:44
 **/

public class HeapSort {

    @Test
    public void testHeapSort() {
        int arr[] = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void heapSort(int arr[]) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}