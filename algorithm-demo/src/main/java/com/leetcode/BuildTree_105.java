package com.leetcode;

import com.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorderMap, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> inorderMap, int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight || inorderLeft > inorderRight) {
            return null;
        }
        int rootVal = preorder[preorderLeft];
        int inOrderRootPosition = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorderMap, preorder, inorder, preorderLeft + 1, preorderLeft-inorderLeft+inOrderRootPosition, inorderLeft, inOrderRootPosition - 1);
        root.right = buildTree(inorderMap, preorder, inorder, preorderLeft-inorderLeft+inOrderRootPosition+1, preorderRight, inOrderRootPosition + 1, inorderRight);
        return root;
    }

    public static void main(String[] args) {
        int [] preorder = {3,9,20,15,7};;
        int [] inorder = {9,3,15,20,7};
        TreeNode res = new BuildTree_105().buildTree(preorder,inorder);
    }
}
