class Solution {
    public int solution(int[] stones, int k) {
        int s = 1, e = 200000000;
        
        int ans = 0;
        while(s <= e) {
            int m = (s + e) / 2;
            if (check(m, k, stones)) {
                s = m + 1;
                ans = Math.max(ans, m);
            } else {
                e = m - 1;
            }
        }
        
        return ans;
    }
    
    static boolean check(int m, int k, int[] stones) {
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < m) cnt++;
            else cnt = 0;
            if (cnt == k) return false; 
        }
        
        return true;
    }
}