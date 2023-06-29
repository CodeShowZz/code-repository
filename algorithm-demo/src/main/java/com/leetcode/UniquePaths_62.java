package com.leetcode;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-29 13:12
 */
public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            path[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i][j-1] + path[i-1][j];
            }
        }
        return path[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths_62().uniquePaths(3,7));
    }
}
