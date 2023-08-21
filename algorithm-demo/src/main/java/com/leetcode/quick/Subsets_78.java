package com.leetcode.quick;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-30 10:05
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(0, nums, temp, res);
        return res;
    }

    public void dfs(int cur, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[cur]);
        dfs(cur + 1, nums, temp, res);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, nums, temp, res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Subsets_78().subsets2(nums);
        System.out.println("res:" + res);
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        dfs2(res,nums,0,new ArrayList<>());
        return res;
    }

    public void dfs2(List<List<Integer>> res,int [] nums,int index,List<Integer> temp) {
        if(index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs2(res,nums,index+1,temp);
        temp.remove(temp.size()-1);
        dfs2(res,nums,index+1,temp);
    }


}