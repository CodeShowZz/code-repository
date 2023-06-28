package com.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-28 10:23
 */
public class Rotate_48 {


    public void  rotate(int[][] matrix) {
        if (matrix == null) {
            return ;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for(int j = 0;j < (n+1) / 2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        new Rotate_48().rotate(matrix);
        for(int i = 0;i<matrix.length;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
