package com.leetcode.lx;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {

        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] s = new int[n+1];
            for(int i =0;i <n;i++)
            {
                s[i+1] = s[i]+nums[i];//构建前缀和数组  s[i]-->前i个数的和
            }
            Map<Integer,Integer> cnt = new HashMap<Integer,Integer>();
            //此时cnt是空的 我们通过后面的遍历去累加当前key有多少
            int ans = 0;
            for(int ts :s)
            {
                // s[j]-s[i] = k  === s[i] = s[j]-k
                ans +=cnt.getOrDefault(ts-k,0);//检查cnt里有没有ts-k(key) 有->返回他的value 没有->返回0
                cnt.merge(ts,1,Integer::sum);//记录ts(key) 的出现次数 记为value  |||  1-->累加
            }
            return ans;

    }
}
