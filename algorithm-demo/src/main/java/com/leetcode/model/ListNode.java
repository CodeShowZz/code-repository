package com.leetcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-02-16 11:34
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

   public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode init(int... nums) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int num : nums) {
            cur.next = new ListNode();
            cur = cur.next;
            cur.val = num;
        }
        return head.next;
    }

    public static ListNode init(List<Integer> nums) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int num : nums) {
            cur.next = new ListNode();
            cur = cur.next;
            cur.val = num;
        }
        return head.next;
    }

    public static List<Integer> traceListNode(ListNode listNode) {
        List<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    static int listNodeToNum(ListNode listNode) {
        if(listNode == null) {
            return 0;
        }
        int time = 1;
        int res = 0;
        while(listNode != null) {
            int val = listNode.val;
            res = res + time * val;
            listNode = listNode.next;
            time = time * 10;
        }
        return res;
    }
}