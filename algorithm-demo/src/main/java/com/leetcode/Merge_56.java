package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-29 10:18
 */
public class Merge_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        //先按区间的开头排个序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] begin = intervals[0];
        List<int[]> tempList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (isOverLap(intervals[i], begin)) {
                begin = merge(intervals[i], begin);
            } else {
                tempList.add(begin);
                begin = intervals[i];
            }
        }
        tempList.add(begin);
        int[][] res = new int[tempList.size()][2];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;
    }

    public boolean isOverLap(int[] intervalA, int[] intervalB) {
        return !(intervalA[1] < intervalB[0] || intervalB[1] < intervalA[0]);
    }

    public int[] merge(int[] intervalA, int[] intervalB) {
        return new int[]{Math.min(intervalA[0], intervalB[0]), Math.max(intervalA[1], intervalB[1])};
    }

    public static void main(String[] args) {
//        int[][] intervals = {{4,5},{1,10}};
//        return new Merge_56().isOverLap(in)
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] res = new Merge_56().merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}