package com.algorithm.leetcode;

import com.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsPalindrome_234 {

    public boolean isPalindrome(ListNode head) {
       List<Integer> res=  traverse(head);
       int i = 0;
       int j = res.size() -1;
       while(i <= j) {
           if(res.get(i) != res.get(j)) {
              return false;
           }
           i++;
           j--;
       }
       return true;
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
        ListNode list = ListNode.init(Arrays.asList(1,2,3,3,2,1));
        boolean flag = new IsPalindrome_234().isPalindrome(list);
        System.out.println("flag:" + flag);
    }
}
