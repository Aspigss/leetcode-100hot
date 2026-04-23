package com.leetcode.lx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums)
        {
            Arrays.sort(nums);//先排序整个nums
            List<List<Integer>> ans = new ArrayList<>();
            //题目没有要求顺序 我们默认i<j<k
            int n = nums.length;
            for(int i = 0 ; i <n-2;i++)
            {
                int now = nums[i];
                //如果遇到了重复数字 会出现重复三元组 跳过这个数字
                if(i>0&&now==nums[i-1]) continue; //为什么是nums[i-1]不是i+1?  因为i>0了 这时候是判断现在和之前的是不是一样的值
                //以i作为第一个数 j k是第二 三个 妙啊
                int j = i+1;
                int k = n-1;
                //优化
                //因为排好序了 如果now和后面两个数字(即最小数字)相加 >0 now和后面任意两个数字相加都是>0 -->也就是现在的最小和都>0了 没必要再i++递归了 直接break
                if(now+nums[i+1]+nums[i+2]>0) break;
                //同理 这里continue是因为 可以移动now 还可能有等于0的情况
                if(now+nums[n-2]+nums[n-1]<0) continue;
                while (j<k)
                {
                    int sum = now+nums[j]+nums[k];
                    if(sum<0)//太小了 移动j
                    {
                        j++;
                    }
                    else if(sum>0) //太大了 移动k
                    {
                        k--;
                    }
                    else//符合题意
                    {
                        //List.of() 把里面的数字转为集合
                        ans.add(List.of(now,nums[j],nums[k]));
                        //本来是要j++ k-- 但是这样不判断可能会有重复三元组出现
                        // 如果遇到了重复数字 会出现重复三元组 跳过这个数字
                        for(j++;j<k&&nums[j]==nums[j-1];j++);//如果和之前的数字相同 跳过
                        for(k--;k>j&&nums[k]==nums[k+1];k--);
                    }
                }
            }
            return ans;
        }
    }

