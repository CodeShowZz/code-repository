package com.util;

import java.security.InvalidParameterException;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-29 13:03
 */
public class MathUtil {

    public static void main(String[] args) {
        System.out.println(calculatePermuteAndCombinationResult(5,3));
    }

    public static int calculatePermuteAndCombinationResult(int m, int n) {
        if(m<n) {
            throw new InvalidParameterException("从m中选取n,n不得大于m");
        }
        int molecule = 1;
        int denominator = 1;
        for (int i = 1; i <= n; i++) {
            denominator = denominator * i;
        }
        for (int j = m; j >= n; j--) {
            molecule = molecule * j;
        }
        return molecule / denominator;
    }
}