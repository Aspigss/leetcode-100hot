package com.leetcode.lx;

public class 两数之和 {
    //无序 用不了双指针
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int i = 0 ;;i++)
            {
                int x = nums[i];
                if(hm.containsKey(target-x))
                {
                    return new int[]{hm.get(target-x),i};
                }
                hm.put(x,i);
            }
        }
    }
}
