package com.leetcode.lx;

import java.util.HashSet;
import java.util.Set;

class 最长连续序列 {
        public int longestConsecutive(int[] nums) {
            //排序的时间复杂度是O(nlogn)不符合题意 不能排序
            //用HashSet 去重就不要判断是否存在了
            Set<Integer> set = new HashSet<>();
            //把nums存进set
            for(int num:nums)
            {
                set.add(num);
            }
            int max = 0;
            for(int num:set)//用set里的值
            {
                //找起始位置
                if(set.contains(num-1))//如果有比num更小的数 就不以num为起始位置
                {
                    continue;
                }
                //找到连续的序列里的 最小起点值num
                int end = num+1;
                while(set.contains(end))//判断是否有下一个连续
                {
                    end++;
                }
                max   = Math.max(max,end-num);//while循环判断结束 end会多一个 本来预期是end-num+1
            }
            return max;
        }
    }
