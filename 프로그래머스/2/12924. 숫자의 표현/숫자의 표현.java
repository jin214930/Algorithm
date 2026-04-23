class Solution {
    public int solution(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = (j + i) * (j - i + 1) / 2;
                if (sum == n) {
                    ans++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        
        return ans;
    }
}