package com.leetcode.lx;

import java.util.*;

class 字母异位词分组 {
    //ps:List<List<String>>和Collection<List<String>>就是[["",""...],["",""....],["",""...]] Lisr<String>就是["","",""...]
    public List<List<String>> groupAnagrams(String[] strs) {
        //思路:用哈希表 key是排序后的目标字符串 value是符合排序后是key的List

        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs)
        {
            //把str转为char[]才能排序
            char c[] = str.toCharArray();
            Arrays.sort(c);
            //判断哈希表是否已经有了目标字符串
            if(map.containsKey(new String(c)))//new String(c)--->把字符数组再转回字符串
            {
                //更新value
                map.get(new String(c)).add(str);
            }
            else//如果没有  把str加到list 再放到map
            {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(new String(c),list);
            }
        }
        return new ArrayList<>(map.values());//map.values()是Collection<List<String>> 但是题目要List<List<String>> 所以要用ArrayList<>()再套一层转化
    }
}