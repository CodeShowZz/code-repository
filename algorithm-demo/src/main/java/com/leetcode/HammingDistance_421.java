package com.leetcode;/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-21 10:57
 */
public class HammingDistance_421 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}