package com.leetcode;

public class CountBits_338 {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i%2==0) {
               res[i] = res[i / 2];
            } else {
                res[i] = res[i-1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] res = new CountBits_338().countBits(5);
    }
}
