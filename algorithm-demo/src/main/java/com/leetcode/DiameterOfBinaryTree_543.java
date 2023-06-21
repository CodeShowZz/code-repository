package com.leetcode;

import com.leetcode.model.TreeNode;

public class DiameterOfBinaryTree_543 {

    private  int ans;

    public int diameterOfBinaryTree(TreeNode root) {
         maxDepth(root);
         return ans - 1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLevel = maxDepth(root.left);
        int rightLevel =  maxDepth(root.right);
        ans = Math.max(leftLevel + rightLevel + 1,ans);
        return Math.max(leftLevel,rightLevel) + 1;
    }
}
