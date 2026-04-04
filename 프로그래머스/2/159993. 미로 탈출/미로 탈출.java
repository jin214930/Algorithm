import java.util.*;

class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int sy = -1, sx = -1;
        int ey = -1, ex = -1;
        int ly = -1, lx = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sy = i;
                    sx = j;
                } else if (maps[i].charAt(j) == 'E') {
                    ey = i;
                    ex = j;
                } else if (maps[i].charAt(j) == 'L') {
                    ly = i;
                    lx = j;
                }
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        q.add(new Node(sy, sx));
        visited[sy][sx] = 1;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.y == ly && node.x == lx) 
                break;
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx] != 0 || maps[ny].charAt(nx) == 'X') continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[node.y][node.x] + 1;
            }
        }
        
        System.out.println(visited[ly][lx]);
        
        if (visited[ly][lx] == 0) {
            return -1;
        }
        
        int ans = visited[ly][lx] - 1;
        
        q = new LinkedList<>();
        visited = new int[n][m];
        q.add(new Node(ly, lx));
        visited[ly][lx] = 1;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.y == ey && node.x == ex) 
                break;
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx] != 0 || maps[ny].charAt(nx) == 'X') continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[node.y][node.x] + 1;
            }
        }
        
        if (visited[ey][ex] == 0) {
            return -1;
        }
        
        return ans + visited[ey][ex] - 1;
    }
    
    class Node {
        int y, x;
        
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}