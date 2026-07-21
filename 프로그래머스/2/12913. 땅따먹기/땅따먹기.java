class Solution {
    int solution(int[][] land) {
        int[][] d = new int[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (i == 0) {
                    d[i][j] = land[i][j];
                    continue;
                }
                for (int k = 0; k < land[0].length; k++) {
                    if (k == j) continue;
                    d[i][j] = Math.max(d[i][j], d[i - 1][k] + land[i][j]);
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < land[0].length; i++) {
            ans = Math.max(ans, d[land.length - 1][i]);
        }
        
        return ans;
    }
}