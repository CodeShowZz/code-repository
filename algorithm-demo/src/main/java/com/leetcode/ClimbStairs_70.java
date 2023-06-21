package com.leetcode;

public class ClimbStairs_70 {

    //1,1,2,3,5,8
    public int climbStairs(int n) {
        int p = 1;
        int q = 1;
        int r = 1;
        for (int i = 1; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }



}
