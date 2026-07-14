class Solution {
    int[] dy = {1, 0, -1};
    int[] dx = {0, 1, -1};
    public int[] solution(int n) {
        int k = n * (n + 1) / 2;
        int[][] a = new int[n][n];
        int y = 0, x = 0, d = 0;
        for (int i = 1; i <= k; i++) {
            a[y][x] = i;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny >= n || nx >= n || a[ny][nx] != 0) {
                d = (d + 1) % 3;
                ny = y + dy[d];
                nx = x + dx[d];
            }
            y = ny;
            x = nx;
        }
        
        int[] ans = new int[k];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) break;
                ans[idx++] = a[i][j]; 
            }
        }
        return ans;
    }
}