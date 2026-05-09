package 相关题目;
    class Solution {
        public int answer(int[] nums, int goal){//answer函数是用来求<goal的个数的
            int l = 0;
            int sum =0;
            int ans = 0;
            for(int r = 0;r<nums.length;r++)
            {
                sum+=nums[r];
                while(sum>=goal)
                {
                    sum-=nums[l];
                    l++;
                }

                ans+= r-l+1;
            }
            return ans;

        }
        public int numSubarraysWithSum(int[] nums, int goal) {

            if(goal>0)
            {//如果知道<goal个数   goal个数可以用<goal+1 个数- <goal个数
                return answer(nums,goal+1)-answer(nums,goal);
            }
            else
            {
                return answer(nums,1);
            }
        }
    }
