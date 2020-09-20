package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author junlin_huang
 * @create 2020-08-30 下午8:08
 **/

public class HasCycle_141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        List<ListNode> listNodeList = new ArrayList();
        ListNode curr = head;
        while (curr != null) {
            listNodeList.add(curr);
            ListNode next = curr.next;
            if (listNodeList.contains(next)) {
                return true;
            }
            curr = next;
        }
        return false;
    }
}