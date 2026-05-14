package com.leetcode.lx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        //定长滑动窗口
        int l = 0;
        int ns = s.length();
        int np = p.length();
        //记录p字符串每个字符出现的次数
        char[] c  = p.toCharArray();
        int[] cntp = new int[26];//!!用int数组记录每个字符出现的次数!
        for (char tc: c)
        {
            cntp[tc-'a']++;
        }
        char[] sc = s.toCharArray();
        List<Integer> ans = new ArrayList<>();
        int[] cnts = new int[26];
        for(int r = 0 ;r<ns;r++)
        {
            cnts[sc[r]-'a']++;//  把S字符串入窗口
            l = r-np+1;
            if (l<0)
            {
                continue;
            }
            if(Arrays.equals(cnts,cntp))//更新   !!Arrays.equals()比较两个数组是否完全相同
            {
                ans.add(l);
            }
            //出
            cnts[sc[l]-'a']--;
        }
        return ans;
    }
}
