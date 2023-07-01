package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-28 10:01
 */
public class Permute_46 {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> res = new Permute_46().permute(nums);
        System.out.println("res:" + res);
    }

    public List<List<Integer>> permute(int [] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        dfs(res,nums,temp,used);
        return res;
    }

    public void dfs(List<List<Integer>> res,int [] nums,List<Integer> temp,boolean [] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++) {
            if(used[i]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            dfs(res,nums,temp,used);
            temp.remove(temp.size() -1);
            used[i] = false;
        }
    }
}