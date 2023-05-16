package com.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompareVersion_165 {

    @Test
    public void compareVersionTest() {
        System.out.println(compareVersion("1.0", "1.0.0"));
    }


    public int compareVersion(String version1, String version2) {
        String[] splits1 = version1.split("\\.");
        String[] splits2 = version2.split("\\.");
        int length1 = splits1.length;
        int length2 = splits2.length;
        int temp1;
        int temp2;
        for (int i = 0; i < Math.max(length1, length2); i++) {
            temp1 = length1 <= i ? 0 : Integer.parseInt(splits1[i]);
            temp2 = length2 <= i ? 0 : Integer.parseInt(splits2[i]);
            if (temp1 != temp2) {
                return temp1 > temp2 ? 1 : -1;
            }
        }
        return 0;
    }
}
