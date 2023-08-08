package com.leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-28 14:17
 */
public class GroupAnagrams_49 {


    public List<List<String>> groupAnagrams(String[] strs)  {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) {
            return res;
        }
        Map<String,List<String>> groupMap = new HashMap<>();
        for(String str : strs) {
            String sortStr = sort(str);
            groupMap.computeIfAbsent(sortStr,item -> new ArrayList<>()).add(str);
        }
        for(Map.Entry<String,List<String>> entry : groupMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public String sort(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return String.valueOf(chs);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new GroupAnagrams_49().groupAnagrams(strs);
        System.out.println("res: " + res);
    }
}