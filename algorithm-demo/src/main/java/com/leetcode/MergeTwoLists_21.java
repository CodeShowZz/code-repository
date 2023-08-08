package com.leetcode;

import com.model.ListNode;

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

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode res = new ListNode();
        ListNode current = res;
        while(list1 != null || list2 != null) {
            if(list1 != null && list2 != null) {
                int val1 = list1.val;
                int val2 = list2.val;
                if(val1 >= val2) {
                    ListNode node = new ListNode(val2);
                    current.next = node;
                    current = current.next;
                    list2 = list2.next;
                } else {
                    ListNode node = new ListNode(val1);
                    current.next = node;
                    current = current.next;
                    list1 = list1.next;
                }
            } else if(list1 != null) {
                current.next = list1;
                break;
            } else if(list2 != null) {
                current.next = list2;
                break;
            }
        }
        return res.next;
    }


    public static void main(String[] args) {
        ListNode list = ListNode.init(1,2,4);
        ListNode list2 = ListNode.init(1,3,4);
        ListNode res = new MergeTwoLists_21().mergeTwoLists(list,list2);
        System.out.println(ListNode.traceListNode(res));
    }
}
