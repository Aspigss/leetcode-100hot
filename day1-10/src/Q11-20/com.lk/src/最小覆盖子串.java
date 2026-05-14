class Solution {
        public String minWindow(String s, String t) {
            int m = s.length();
            int n = t.length();
            int[] ct = new int[128];
            int[] cs = new int[128];
            //定义最小字串的 sl sr
            int sl = -1;
            int sr = m;
            int l = 0;
            for(char c  : t.toCharArray())
            {
                ct[c]++;
            }
            char[] ts =  s.toCharArray();
            for(int r = 0 ; r<m;r++)
            {
                cs[ts[r]]++;
                while(isCover(cs,ct))//约束窗口
                {
                    if(r-l<sr-sl)
                    {
                        sl = l;
                        sr = r;

                    }
                    cs[ts[l]]--;
                    l++;
                }
            }
            return sl<0 ?  ""  : s.substring(sl,sr+1);

        }
        static public boolean isCover(int[] cs,int[] ct)
        {
            for(int i = 'A';i<='Z';i++)
            {
                if(cs[i]<ct[i])
                {
                    return false;
                }
            }
            for (int i = 'a'; i <= 'z'; i++) {
                if (cs[i] < ct[i]) {
                    return false;
                }
            }
            return true;
        }
    }
