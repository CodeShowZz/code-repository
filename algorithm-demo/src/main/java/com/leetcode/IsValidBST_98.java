package com.leetcode;

import com.model.TreeNode2;

public class IsValidBST_98 {

    private Long preInOrderValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode2<Long> root) {
       if(root == null) {
           return false;
       }
       return inOrder(root);
    }

    public boolean inOrder(TreeNode2<Long> root) {
        if(root == null) {
            return true;
        }
        if(!inOrder(root.left)){
            return false;
        }
        if(root.val <= preInOrderValue) {
            return false;
        }
        preInOrderValue = root.val;
        return inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode2<Long> root = new TreeNode2(1L);
        root.left = new TreeNode2(1L);
//        root.right = new TreeNode(3);
        new IsValidBST_98().isValidBST(root);
    }
}
