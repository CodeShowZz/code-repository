package com.leetcode;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Map<Integer,List<Integer>> levelMap = new HashMap<>();
        inOrder(levelMap,root,0);
        for(Map.Entry<Integer,List<Integer>> entry : levelMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public void inOrder(Map<Integer,List<Integer>> levelMap,TreeNode root,int level) {
        if(root == null) {
            return ;
        }
        levelMap.computeIfAbsent(level,item -> new ArrayList<>()).add(root.val);
        inOrder(levelMap,root.left,level+1);
        inOrder(levelMap,root.right,level+1);
    }
}
