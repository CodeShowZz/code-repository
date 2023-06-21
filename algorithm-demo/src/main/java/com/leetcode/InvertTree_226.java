package com.leetcode;

import com.leetcode.model.TreeNode;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-05-12 14:08
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {
        invertTree2(root);
        return root;
    }

    public void invertTree2(TreeNode root) {
        if(root == null) {
            return;
        }
        invertTree2(root.left);
        invertTree2(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        new InvertTree_226().invertTree(root);

    }
}