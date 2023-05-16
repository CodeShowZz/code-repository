package com.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对版本号进行排序
 */
public class SortVersion {

    @Test
    public void testCompareVersion() {

        List<String> versionList = Arrays.asList("1.3.4", "0.3.54", "5.3.2", "4.2.1", "0.3.0", "0.3");
        Collections.sort(versionList, (o1, o2) -> compareVersion(o1, o2));
        System.out.println(versionList);
    }


    int compareVersion(String version1, String version2) {
        version1 = simplifyVersion(version1);
        version2 = simplifyVersion(version2);

        List<Integer> splitResult1 = Arrays.asList(version1.split("\\.")).stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        List<Integer> splitResult2 = Arrays.asList(version2.split("\\.")).stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        if (splitResult1.get(splitResult1.size() - 1) == 0) {
            splitResult1.remove(splitResult1.size() - 1);
        }
        if (splitResult1.get(splitResult1.size() - 1) == 0) {
            splitResult1.remove(splitResult1.size() - 1);
        }

        int minSize = Math.min(splitResult1.size(), splitResult2.size());
        for (int i = 0; i < minSize; i++) {
            if (splitResult1.get(i) > splitResult2.get(i)) {
                return 1;
            } else if (splitResult1.get(i) < splitResult2.get(i)) {
                return -1;
            }
        }
        if (splitResult1.size() == splitResult2.size()) {
            return 0;
        } else if (splitResult1.size() > splitResult2.size()) {
            return 1;
        } else {
            return -1;
        }
    }


    public String simplifyVersion(String str1) {
        List<Integer> splitResult = Arrays.asList(str1.split("\\.")).stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        String simplifyVersion = "";
        for (int i = splitResult.size() - 1; i >= 0; i--) {
            if (splitResult.get(i) == 0) {
                splitResult.remove(i);
                if (splitResult.size() == 0) {
                    return "0";
                }
            } else {
                simplifyVersion = splitResult.stream().map(x -> x.toString())
                        .collect(Collectors.joining("."));
            }
        }
        return simplifyVersion;
    }
}
