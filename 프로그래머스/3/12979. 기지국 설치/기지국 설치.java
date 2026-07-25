class Solution {    
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        int x = 1;
        for (int station : stations) {
            if (x > n) break;
            int s = station - w;
            int e = station + w;
            if (x < s) {
                ans += (s - x + 2 * w) / (2 * w + 1);
            }
            x = e + 1;
        }
        
        if (x <= n) {
            ans += (n + 1 - x + 2 * w) / (2 * w + 1);
        }
        
        return ans;
    }
}