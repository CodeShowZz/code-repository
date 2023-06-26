package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res,"", n, n);
        return res;
    }

    public void dfs(List<String> res, String temp, int left, int right) {
        if(left == 0 && right == 0) {
            res.add(temp);
            return;
        }
        if(left > right) {
            return;
        }
        if(left > 0) {
            dfs(res,temp + "(" ,left - 1,right);
        }
        if(right > 0) {
            dfs(res,temp +")",left,right-1);
        }
    }
}
