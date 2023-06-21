package com.leetcode;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        return res;
}

    public  void  inorderTraversal(TreeNode root,List<Integer> res) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left,res);
        res.add(root.val);
        inorderTraversal(root.right,res);
    }


}
