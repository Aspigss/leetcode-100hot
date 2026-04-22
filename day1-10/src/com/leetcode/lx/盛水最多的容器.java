package com.leetcode.lx;

class  盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        //思路:要想要最大面积 先拿一个已知的最大长(两个指针距离) 然后再此基础上缩短更短的边(如果缩短更长边只会更小) 对比面积是否更大 更大就更新
        while(left<right)
        {
            int area = (right-left)*Math.min(height[left],height[right]);//长(指针之间的距离)乘宽(两个指针对应的height取一个最小值)
            //因为想要最多水  取决于移动更短边是否会使得面积更大 取前后面积的最大就可以
            max = Math.max(area,max);
            if(height[left]<height[right])//短边在左
            {
                left++;
            }
            else//短边在右
            {
                right--;
            }
        }
        return max;
    }
}   