import java.util.ArrayDeque;
import java.util.Deque;

public class 滑动窗口最大值 {
//     公司工位固定 k 个。

// 每天来一个新人。
// 他从队伍末尾往前杀：见一个比他弱的，杀一个。
// 杀完，自己坐到最后。
// 如果人数超过 k，就把最前面那个人杀了，不管他强不强。
// 然后，记下现在最前面那个人的名字。

// 日复一日。

        // 一年后翻开本子——
// 上面记的，是每个 k 天窗口里，活到最后的那把刀
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dl = new ArrayDeque<>();//队列存要被杀的人的坐标(索引)
            int n = nums.length;
            int[] ans = new int[n-k+1];
            for(int r = 0;r<nums.length;r++)
            {
                while(!dl.isEmpty()&&nums[dl.getLast()]<=nums[r])//新人来了 开杀
                {
                    dl.removeLast();
                }
                dl.addLast(r);//杀完比新人小的 新人进来

                //如果没有比新人小的 然后人太多坐不下了 杀掉最前面的
                int l = r-k+1;
                if(dl.getFirst()<l)
                {
                    dl.removeFirst();//杀掉最前面的
                }
                //杀完了 记录最前面的人
                if(l>=0)
                {
                    ans[l] = nums[dl.getFirst()];
                }
            }
            return ans;
        }
    }

