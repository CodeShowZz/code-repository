package com.algorithm.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

   public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public static ListNode init(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for(Integer i : list) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }

    public static List<Integer> traverse(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while(head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode res = ListNode.init(Arrays.asList(1,2,3,4,5));
        System.out.println(ListNode.traverse(res));
    }
}
