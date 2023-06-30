package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-30 14:15
 */
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
        if(candidates == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(0,candidates,target,temp,res);
        return res;
    }

    public void dfs(int begin,int []candidates,int target,List<Integer> temp,List<List<Integer>> res) {
        if(target < 0) {
            return;
        } else if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = begin;i<candidates.length;i++) {
            temp.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], temp, res);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] nums = {2,3,6,7};
        List<List<Integer>> res= new CombinationSum_39().combinationSum(nums,7);
        System.out.println(res);
    }
}