package com.leetcode;


import com.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        List<Integer> res = traverse(head);
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        for(int i =res.size()-1;i>=0;i--) {
            temp.next = new ListNode(res.get(i));
            temp = temp.next;
        }
        return newHead.next;
    }

    public static List<Integer> traverse(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while(head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }

}
