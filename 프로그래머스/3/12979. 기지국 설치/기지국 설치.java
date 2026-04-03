class Solution {
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        int tmp = 1;
        for (int s : stations) {
            if (tmp < s - w) {
                ans += (s - w - tmp + 2 * w) / (2 * w + 1);
            
            } 
            tmp = s + w + 1;
        }
        
        ans += (n + 1 - tmp + 2 * w) / (2 * w + 1);
        return ans;
    }
}