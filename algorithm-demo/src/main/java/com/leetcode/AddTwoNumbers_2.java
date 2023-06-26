package com.leetcode;

import com.model.ListNode;
import com.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-26 10:13
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.init(2,4,3);
        ListNode l2 = ListNode.init(5,6,4);
        ListNode res = new AddTwoNumbers_2().addTwoNumbers(l1, l2);
        System.out.println(ListNode.traceListNode(res));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        boolean addOneFlag = false;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val = l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                val = l2.val;
                l2 = l2.next;
            }
            if (addOneFlag) {
                val = val + 1;
            }
            if (val >= 10) {
                val = val - 10;
                addOneFlag = true;
            } else {
                addOneFlag = false;
            }
            ListNode node = new ListNode();
            node.val = val;
            cur.next = node;
            cur = node;
        }
        if(addOneFlag) {
            ListNode lastNode = new ListNode(1);
            cur.next = lastNode;
        }
        return head.next;
    }


}