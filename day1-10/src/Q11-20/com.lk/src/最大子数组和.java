public class 最大子数组和 {

        public int maxSubArray(int[] nums) {
            int ans = Integer.MIN_VALUE;
            int preSum =0; //当前前缀和
            int minPresum  = 0;//最小前缀和
            for(int n : nums)
            {
                preSum +=n;//更新当前前缀和
                ans = Math.max(ans,preSum-minPresum);//答案是当前-最小
                minPresum = Math.min(minPresum,preSum);//更新最小
            }
            return ans;
        }
    }