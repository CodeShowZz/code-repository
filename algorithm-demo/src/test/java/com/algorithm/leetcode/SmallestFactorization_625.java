package com.algorithm.leetcode;

import org.junit.Test;

/**
 *
 * @author junlin_huang
 * @create 2020-09-17 下午10:14
 **/
public class SmallestFactorization_625 {

    @Test
    public void smallestFactorization() {
        System.out.print(smallestFactorization(9765625));
    }

    public int smallestFactorization(int a) {
        if (a == 1) {
            return 1;
        }
        long result = 0;
        long mul = 1;
        for (int i = 9; i != 1; ) {
            if (a % i == 0) {
                a = a / i;
                result = mul * i + result;
                mul = mul * 10;
            } else {
                i--;
            }
        }
        return a == 1 && result <= Integer.MAX_VALUE ? (int)result : 0;
    }

    public int smallestFactorization2(int a) {
        if (a < 2)
            return a;
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int) res : 0;
    }


}