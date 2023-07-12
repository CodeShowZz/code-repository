package com.model;

public class TreeNode2<T> {
    public T val;
    public TreeNode2 left;
    public TreeNode2 right;
    public TreeNode2() {

    }
    public TreeNode2(T val) {
        this.val = val;
    }

    public TreeNode2(T val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void preTraverse(TreeNode2 treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preTraverse(treeNode.left);
        preTraverse(treeNode.right);
    }

}
