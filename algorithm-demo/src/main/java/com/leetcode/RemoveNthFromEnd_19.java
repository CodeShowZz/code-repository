package com.leetcode;

import com.model.ListNode;

public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {
        ListNode head = ListNode.init(1);
        new RemoveNthFromEnd_19().removeNthFromEnd2(head,1);
    }
//
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head == null) {
//            return null;
//        }
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        ListNode front = dummy;
//        ListNode behind = dummy;
//        for(int i = 0;i < n;i++) {
//            front = front.next;
//        }
//        while(front.next != null) {
//            front = front.next;
//            behind = behind.next;
//        }
//        behind.next = behind.next.next;
//        return dummy.next;
//    }









    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode front = dummy;
        ListNode behind = dummy;
        for(int i = 0; i< n;i++) {
            front = front.next;
        }
        while(front.next != null) {
            front = front.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return dummy.next;
    }
}
