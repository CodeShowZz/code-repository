package com.model;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {

    }
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void preTraverse(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preTraverse(treeNode.left);
        preTraverse(treeNode.right);
    }

}
