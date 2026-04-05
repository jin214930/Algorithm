class Solution {
    public int solution(int n) {
        boolean[] p = new boolean[n + 1];
        p[1] = true;
        
        for (int i = 2; i <= n;i++) {
            for(int j = i * 2; j <= n; j+=i) {
                if(!p[j])
                    p[j] = true;
            }
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(!p[i])
                ans++;
        }
        return ans;
    }
}