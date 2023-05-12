package com.leetcode;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
    }

    public List<Integer> inorderTraversal(TreeNode root,List<Integer> res) {
            return null;
    }
}
