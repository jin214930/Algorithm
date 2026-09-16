import java.util.*;

class Solution {
    static int n, m;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || maps[i].charAt(j) == 'X') continue;
                list.add(dfs(i, j, maps));
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
    
    static int dfs(int y, int x, String[] maps) {
        visited[y][x] = true;
        
        int ret = maps[y].charAt(x) - '0';
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (maps[ny].charAt(nx) == 'X' || visited[ny][nx]) continue;
            ret += dfs(ny, nx, maps); 
        }
        
        return ret;
    }
}