class Solution {
    int solution(int[][] land) {
        int[][] d = new int[land.length][4];
        
        for (int i = 0; i < 4; i++) {
            d[0][i] = land[0][i];
        }
        
        int ans = 0;
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    max = Math.max(max, d[i - 1][k]);
                }
                d[i][j] = max + land[i][j];
                if (i == land.length - 1) {
                    ans = Math.max(ans, d[i][j]);
                }
            }
        }
        
        return ans;
    }
}