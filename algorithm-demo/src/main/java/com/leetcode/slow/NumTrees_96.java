package com.leetcode.slow;

public class NumTrees_96 {

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new NumTrees_96().numTrees2(3));
    }






    public int numTrees2(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int [] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2;i<=n;i++) {
             for(int j = 1;j <= i;j++) {
                 res[i] += res[j-1] * res[i-j];
             }
        }
        return res[n];
    }









}
