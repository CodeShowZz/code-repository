package com.leetcode;

import com.model.TreeNode;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-06-19 10:58
 */
public class SortedArrayToBST_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int [] nums,int left,int right) {
        if(left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }


    public static void main(String[] args) {
        int [] nums = {-10,-3,0,5,9};
        TreeNode treeNode = new SortedArrayToBST_108().sortedArrayToBST(nums);
        TreeNode.preTraverse(treeNode);
    }
}