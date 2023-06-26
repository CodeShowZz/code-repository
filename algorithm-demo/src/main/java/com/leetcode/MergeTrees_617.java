package com.leetcode;

import com.model.TreeNode;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-25 20:43
 */
public class MergeTrees_617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root2 == null ? root1 : root2;
        }
        return dfs(root1,root2);
    }

    public TreeNode dfs(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root2 == null ? root1 : root2;
        }
        root1.val = root1.val + root2.val;
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right,root2.right);
        return root1;
    }
}