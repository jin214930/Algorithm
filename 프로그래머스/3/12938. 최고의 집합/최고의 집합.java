class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};
        int[] ans = new int[n];
        
        int tmp = s % n;
        for (int i = 0; i < n; i++) {
            if (i < n - tmp) ans[i] = s / n;
            else ans[i] = s / n + 1;
        }
        return ans;
    }
}