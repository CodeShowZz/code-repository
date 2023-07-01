package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public static void main(String[] args) {
        List<List<Integer>> res = new CombinationSum_39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, candidates, target, res, temp);
        return res;
    }

    public void dfs(int begin, int[] candidates, int target, List<List<Integer>> res, List<Integer> temp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
