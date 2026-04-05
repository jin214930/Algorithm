class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int s = 1, e = 0;
        for (int diff : diffs)
            e = Math.max(e, diff);
        
        int ans = 0;
        while(s <= e) {
            int m = (s + e) / 2;
            if (check(m, diffs, times, limit)) {
                e = m - 1;
                ans = m;
            } else
                s = m + 1;
        }
        
        return ans;
    }
    
    boolean check(long m, int[] diffs, int[] times, long limit) {
        long sum = 0L;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= m)
                sum += times[i];
            else {
                sum += (diffs[i] - m + 1) * times[i];
                if (i != 0)
                    sum += times[i - 1] * (diffs[i] - m);
            }
        }
        
        return sum <= limit;
    }
}