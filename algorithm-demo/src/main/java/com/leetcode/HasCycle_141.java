package com.leetcode;


import com.model.ListNode;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-05-09 14:18
 */
public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
            if(fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.init(3,2,0,-4);
        System.out.println(new HasCycle_141().hasCycle(head));
    }
}