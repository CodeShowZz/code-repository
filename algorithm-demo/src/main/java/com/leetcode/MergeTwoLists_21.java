package com.leetcode;

import com.leetcode.model.ListNode;

public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(0);
        ListNode tempHead = newList;
        while(list1 != null || list2 != null) {
            if(list1 != null && list2 != null) {
                if(list1.val < list2.val) {
                    tempHead.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    tempHead.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                tempHead = tempHead.next;
            } else if(list1 != null) {
                tempHead.next = list1;
                break;
            } else if(list2 != null) {
                tempHead.next = list2;
                break;
            }
        }
        return newList.next;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.init(1,2,4);
        ListNode list2 = ListNode.init(1,3,4);
        ListNode res = new MergeTwoLists_21().mergeTwoLists(list,list2);
        System.out.println(ListNode.traceListNode(res));
    }
}
