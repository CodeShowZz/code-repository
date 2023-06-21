package com.leetcode;


import com.model.ListNode;

public class GetIntersectionNode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        while(tempHeadA != tempHeadB) {
            if(tempHeadA != null) {
                tempHeadA = tempHeadA.next;
            } else {
                tempHeadA = headB;
            }
            if(tempHeadB != null) {
                tempHeadB = tempHeadB.next;
            } else {
                tempHeadB = headA;
            }
        }
        return tempHeadA;
    }

    public static void main(String[] args) {

    }
}
