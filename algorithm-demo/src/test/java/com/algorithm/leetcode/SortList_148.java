package com.algorithm.leetcode;

import org.junit.Test;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */
public class SortList_148 {

    @Test
    public void testSortList() {
        ListNode first = new ListNode(4);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(8);
        ListNode fouth = new ListNode(3);
        ListNode fifth = new ListNode(1);
        first.next = second;
        second.next = third;
        third.next = fouth;
        fouth.next = fifth;
        ListNode result = sortList(first);
    }


    /**
     * 归并排序递归版本
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode curr = h;
        while (left != null || right != null) {
            if (left == null) {
                curr.next = right;
                right = right.next;
            } else if (right == null) {
                curr.next = left;
                left = left.next;
            } else {
                if (left.val > right.val) {
                    curr.next = right;
                    right = right.next;
                } else {
                    curr.next = left;
                    left = left.next;
                }
            }
            curr = curr.next;
        }
        return h.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}



