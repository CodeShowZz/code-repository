package com.leetcode;

import java.util.*;

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

    public int[][] merge2(int[][] intervals) {
        if(intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int []> resList = new ArrayList<>();
        int [] tempArea = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            int[] area = intervals[i];
            if(isOverLap2(tempArea,area)) {
                tempArea = mergeArea2(tempArea,area);
            } else {
                resList.add(tempArea);
                tempArea = area;
            }
        }
        resList.add(tempArea);
        int [][] res =new int[resList.size()][];
        for(int i = 0 ; i <res.length;i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public boolean isOverLap2(int [] area1,int [] area2) {
        return !(area1[1] < area2[0]);
    }

    public int [] mergeArea2(int [] area1,int [] area2) {
        return new int[]{area1[0],Math.max(area1[1],area2[1])};
    }


    public static void main(String[] args) {
//        int[][] intervals = {{4,5},{1,10}};
//        return new Merge_56().isOverLap(in)
//        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new Merge_56().merge2(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}