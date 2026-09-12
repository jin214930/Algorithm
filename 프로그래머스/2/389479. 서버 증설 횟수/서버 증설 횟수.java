class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0;
        int ans = 0;
        
        int[] remove = new int[25];
        for (int i = 0; i < 24; i++) {
            cnt -= remove[i];
            int required = players[i] / m;
            if (required > cnt) {
                int need = required - cnt;
                ans += need;
                cnt += need;
                remove[Math.min(i + k, 24)] = need;
            }
        }
        return ans;
    }
}