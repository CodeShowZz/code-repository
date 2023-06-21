package com.leetcode;

import com.leetcode.model.TreeNode;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-05-12 11:55
 */
public class MaxDepth_104 {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLevel = maxDepth(root.left);
        int rightLevel =  maxDepth(root.right);
        return Math.max(leftLevel,rightLevel ) +1;
    }
}