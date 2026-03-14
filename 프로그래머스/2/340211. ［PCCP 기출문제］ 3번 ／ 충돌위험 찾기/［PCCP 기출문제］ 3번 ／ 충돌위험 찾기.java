class Solution {
    int[][][] cnt = new int[101][101][300];
    
    public int solution(int[][] points, int[][] routes) {
        
        for (int i = 0; i < routes.length; i++) {
            check(points[routes[i][0] - 1], points[routes[i][1] - 1]);
        }
        
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                for (int k = 0; k < 300; k++) {
                    if (cnt[i][j][k] >= 2) {
                        ans++;
                    }
                }
            }
        }
        
        return ans;
    }
    
    void check(int[] s, int[] e) {
        int t = 0;
        
        int r = s[0], c = s[1];
        
        while (!(r == e[0] && c == e[1])) {
            cnt[r][c][t]++;
            
            if (r == e[0]) {
                if (c > e[1])
                    c--;
                else
                    c++;
            } else {
                if (r > e[0])
                    r--;
                else
                    r++;
            }
            
            t++;
        }
        
        cnt[r][c][t]++;
    }
}