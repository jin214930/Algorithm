import java.util.*;

class Solution {
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int sy, sx, ey, ex, ly, lx;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sy = i;
                    sx = j;
                } else if (c == 'L') {
                    ly = i;
                    lx = j;
                } else if (c == 'E') {
                    ey = i;
                    ex = j;
                }
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        q.add(new Node(sy, sx));
        visited[sy][sx] = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == ly && cur.x == lx) break;
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (maps[ny].charAt(nx) == 'X' || visited[ny][nx] != 0) continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
            }
        }
        
        if (visited[ly][lx] == 0) return -1;
        int ans = visited[ly][lx] - 1;
        
        q.clear();
        visited = new int[n][m];
        q.add(new Node(ly, lx));
        visited[ly][lx] = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == ey && cur.x == ex) break;
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (maps[ny].charAt(nx) == 'X' || visited[ny][nx] != 0) continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
            }
        }
        
        if (visited[ey][ex] == 0) return -1;
        
        return ans + visited[ey][ex] - 1;
    }
}