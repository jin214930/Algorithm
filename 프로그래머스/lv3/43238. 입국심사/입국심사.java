class Solution {
    boolean check(long m, int n, int[] times) {
        long cnt = 0;
        for (int time : times) {
            cnt += m / time;
        }
        
        return cnt >= n;
    }
    
    public long solution(int n, int[] times) {
        long s = 1L;
        long e = 1000000000000000000L;
        
        long ans = 0;
        while(s <= e) {
            long m = (s + e) / 2;
            if(check(m, n, times)) {
                ans = m;
                e = m - 1;
            } else
                s = m + 1;
        }
        
        return ans;
    }
}