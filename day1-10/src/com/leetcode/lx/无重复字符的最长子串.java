package com.leetcode.lx;

class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {//不定长滑动窗口
        {
            int l = 0;
            char[] c = s.toCharArray();
            int max = 0;
            int length = s.length();
            int[] tag = new int[128];
            for(int r = 0;r<length;r++)//右端点右移
            {
                char now = c[r];
                tag[now]++;

                while(tag[now]>1)//重复字符 (不满足题意) 缩小窗口
                {
                    tag[c[l]]--;//维护窗口
                    l++;
                }

                max = Math.max(max,r-l+1);
            }
            return  max;
        }
    }
}