class Solution {
    public long solution(int n, int[] times) {
        long ans = 0;
        long s = 1, e = (long)1e18;
        while(s <= e) {
            long m = (s + e) / 2;
            long cnt = 0;
            for(int i : times)
                cnt += m / i;
            if(cnt >= n) {
                ans = m;
                e = m -1;
            }
            else
                s = m + 1;
        }
        return ans;
    }
}