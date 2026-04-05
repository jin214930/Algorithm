import java.util.*;

class Solution {
    int n, m, idx = 1;
    int[][] visited;
    
    int[] dy = {0, 0, -1, 1};
    int[] dx = {1, -1, 0, 0};
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        
        visited = new int[n][m];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || visited[i][j] != 0) continue;
                int cnt = dfs(i, j, land);
                map.put(idx, cnt);
                idx++;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            boolean[] check = new boolean[idx];
            for (int j = 0; j < n; j++) {
                if (visited[j][i] != 0 && !check[visited[j][i]]) {
                    sum += map.get(visited[j][i]);
                    check[visited[j][i]] = true;
                }
            }
            ans = Math.max(ans, sum);
        }
        
        return ans;        
    }
    
    int dfs(int y, int x, int[][] land) {
        int tmp = 1;
        visited[y][x] = idx;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
            if (land[ny][nx] == 0 || visited[ny][nx] != 0) continue;
            tmp += dfs(ny, nx, land);
        }

        return tmp;            
    } 
}