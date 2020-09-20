package com.algorithm.leetcode;

/**
 * @author junlin_huang
 * @create 2020-09-18 上午1:06
 **/

public class AddTwoNumbers_2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHeadListNode = new ListNode(0);
        ListNode curr = sumHeadListNode;
        boolean isNextAddOne = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null && l2 != null) {
                sum = l2.val;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                sum = l1.val;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (isNextAddOne) {
                sum = sum + 1;
                isNextAddOne = false;
            }
            if (sum >= 10) {
                sum = sum - 10;
                isNextAddOne = true;
            }
            ListNode sumListNode = new ListNode(sum);
            curr.next = sumListNode;
            curr = sumListNode;
        }
        if (isNextAddOne) {
            ListNode sumListNode = new ListNode(1);
            curr.next = sumListNode;
        }
        return sumHeadListNode.next;
    }
}