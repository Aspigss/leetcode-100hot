package com.leetcode.lx;

public class 接雨水 {
        public int trap(int[] height) {
            //把这个方块看成挡板来理解  两个挡板之间 每个位置 能存的最多的水(就算挡板之间有黑色方块 也不看 只看最短挡板的高度是多少就是这个位置能存最多的水数量) 也就只能是最短挡板的高度 (如果超过看图 是流出去的不算)

            //按这种思路 我们建立两个记录 每个位置可以存最大水的数组 一个以左边的开始为最短挡板 一个一右边开始为最短挡板  然后取这两个数组当前位置的最小值(也就是这个位置真正能存的最多的水) 然后再减去这个位置原来有几个方块 就是这个位置能存的水ans;----------2

            //那怎么算每个位置能最多能存多少水呢??  -->因为每个位置存水的数量 要看前面挡板高度 所以比较当前height[index]高度和前面的最大高度水大 取最大的就是这个地方能存的最多的水 (suf_max同理)----3

            int n = height.length;
            int[] pre_max = new int[n];
            pre_max[0] = height[0]; //0位置的就把当前height作为最大值
            for (int i = 1; i < n; i++) {
                pre_max[i] = Math.max(height[i], pre_max[i - 1]);//-------3
            }
            int[] suf_max = new int[n];
            suf_max[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suf_max[i] = Math.max(suf_max[i + 1], height[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.min(pre_max[i], suf_max[i]) - height[i];//----2
            }
            return ans;
        }
}
