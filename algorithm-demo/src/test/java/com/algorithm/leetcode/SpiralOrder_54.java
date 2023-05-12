package com.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//
public class SpiralOrder_54 {

    @Test
    public void testSpiralOrder() {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(nums));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> pathList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return pathList;
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        boolean[][] visited = new boolean[rowLength][columnLength];
        int total = rowLength * columnLength;
        int directionIndex = 0;
        int row = 0;
        int column = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < total; i++) {
            pathList.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + direction[directionIndex][0];
            int nextColumn = column + direction[directionIndex][1];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= rowLength || nextColumn >= columnLength || visited[nextRow][nextColumn] == true) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + direction[directionIndex][0];
            column = column + direction[directionIndex][1];
        }
        return pathList;
    }
}



