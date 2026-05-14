package com.leetcode.lx;

class 移动零 {
    public void moveZeroes(int[] nums) {
        //  //把nums自己当作栈 把不是0的入栈 然后最后用0填充
        //  int stackSize = 0;
        //  for(int num:nums)
        //  {
        //     if(num!=0)//不是0 num入栈  stackSize 表示栈的大小
        //     {
        //         nums[stackSize++] = num;
        //     }
        //  }
        //  //全部不为0 的已经入栈 现在用0 从stackSize 到 nums.length-1填充栈
        //  Arrays.fill(nums,stackSize,nums.length,0);

        //法2
        int i0 = 0;//i0是去找空位(0)的指针 如果没有空位i0++ 有空位i0不变 然后nums[i0]是空位 去和下一个nums[i]不是空位的交换
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                int t = nums[i];
                nums[i] = nums[i0];
                nums[i0] = t;
                i0++;
            }
        }
    }
}