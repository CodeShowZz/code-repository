package com.algorithm;

import java.util.Arrays;

/**
 * 1. 给定一个8x8的棋盘, 上面有若干个车(Rook),写一个函数检查这些车有没有互相攻击的情况.
 * 2. 在1题的基础上, 给定一个初始棋盘状态, 问最多还能放置多少个车, 使他们不会互相攻击, 如何放置?
 * 3. 在1,2的基础上, 如果棋盘不止有车, 还有象(Bishop)和皇后(Queen),该如何检查是否有互相攻击的情况.
 * <p>
 * 国际象棋走法：
 * 车：横、竖均可以走，步数不受限制，不能斜走。
 * 象：只能斜走。格数不限，不能越子。
 * 后：横、直、斜都可以走，步数不受限制，但不能越子。
 *
 * @author junlin_huang
 * @create 2020-10-16 下午8:06
 **/

public class Main {

    public static void main(String[] args) {
        int[][] nums = new int[8][8];
        nums[2][3] = 1;
        nums[4][2] = 1;
        testCanAttack(nums);
        testMaxChessNoAttack(nums);
    }

    public static void testCanAttack(int[][] nums) {
        System.out.println("can attack:" + canAttack(nums));
    }

    public static void testMaxChessNoAttack(int[][] nums) {
        System.out.println("max:" + maxChessNoAttack(nums));
    }


    public static int maxChessNoAttack(int[][] nums) {
        Integer max = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (nums[i][j] == 0) {
                    nums[i][j] = 1;
                    if (canAttack(nums)) {
                        nums[i][j] = 0;
                    } else {
                        max++;
                    }
                }
            }
        }
        return max;
    }

    public static boolean canAttack(int[][] nums) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (nums[i][j] == 1) {
                    //判断X轴
                    for (int k = 0; k < 8; k++) {
                        if (nums[i][k] == 1 && k != j) {
                            return true;
                        }
                    }

                    //判断Y轴
                    for (int k = 0; k < 8; k++) {
                        if (nums[k][j] == 1 && k != i) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}