package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumbers_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length;i++) {
            if(!hashSet.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new FindDisappearedNumbers_448().findDisappearedNumbers(nums));
    }
}
