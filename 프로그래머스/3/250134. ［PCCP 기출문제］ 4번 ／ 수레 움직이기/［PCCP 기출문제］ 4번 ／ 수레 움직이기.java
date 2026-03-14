class Solution {
    int n, m, ery, erx, eby, ebx;
    int ans = Integer.MAX_VALUE;
    boolean[][] visitedRed, visitedBlue;
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        
        visitedRed = new boolean[n][m];
        visitedBlue = new boolean[n][m];
        
        int sry = -1, srx = -1, sby = -1, sbx = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    sry = i;
                    srx = j;
                } else if (maze[i][j] == 2) {
                    sby = i;
                    sbx = j;
                } else if (maze[i][j] == 3) {
                    ery = i;
                    erx = j;
                } else if (maze[i][j] == 4) {
                    eby = i;
                    ebx = j;
                }
            }
        }
        
        visitedRed[sry][srx] = true;
        visitedBlue[sby][sbx] = true;
        dfs(sry, srx, sby, sbx, 0, maze);
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
    void dfs(int ry, int rx, int by, int bx, int cnt, int[][] maze) {    
        boolean redDone = ry == ery && rx == erx;
        boolean blueDone = by == eby && bx == ebx;
        
        if (redDone && blueDone) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        if (cnt >= ans) return;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int nry = redDone ? ry : ry + dy[i];
                int nrx = redDone ? rx : rx + dx[i];
                
                int nby = blueDone ? by : by + dy[j];
                int nbx = blueDone ? bx : bx + dx[j];
                
                if (nry < 0 || nrx < 0 || nry >= n || nrx >= m) continue;
                if (nby < 0 || nbx < 0 || nby >= n || nbx >= m) continue;
                if (maze[nry][nrx] == 5 || (!redDone && visitedRed[nry][nrx])) continue;
                if (maze[nby][nbx] == 5 || (!blueDone && visitedBlue[nby][nbx])) continue;
                if (nry == nby && nrx == nbx) continue;
                if (nry == by && nrx == bx && nby == ry && nbx == rx) continue;
                
                if (!redDone) visitedRed[nry][nrx] = true;
                if (!blueDone) visitedBlue[nby][nbx] = true;
                
                dfs(nry, nrx, nby, nbx, cnt + 1, maze);
                
                if (!redDone) visitedRed[nry][nrx] = false;
                if (!blueDone) visitedBlue[nby][nbx] = false;
            }
        }
    }
}