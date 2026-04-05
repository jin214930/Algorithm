class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
        int n = dp.length;
        
        for(int i = 0; i < n; i++)
            dp[n - 1][i] = triangle[n - 1][i];
        
        for (int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}