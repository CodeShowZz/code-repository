package com.leetcode.quick;

public class MinPathSum_64 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = new MinPathSum_64().minPathSum2(grid);
        System.out.println("res:" + res);
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row;i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0 && j ==0) {
                    res[i][j] = grid[i][j];
                } else if(i == 0) {
                    res[i][j] = res[i][j-1] + grid[i][j];
                } else if(j == 0) {
                    res[i][j] = res[i-1][j] + grid[i][j];
                } else {
                    res[i][j] = Math.min(res[i-1][j],res[i][j-1]) + grid[i][j];
                }
            }
        }
        return res[row-1][col-1];
    }


}
