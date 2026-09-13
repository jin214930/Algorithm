import java.util.*;

class Solution {
    static class Node {
        int y, x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int n, m;
    static int ey, ex;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    visited[i][j] = 1;
                    q.add(new Node(i, j));                    
                } else if (c == 'G') {
                    ey = i;
                    ex = j;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == ey && cur.x == ex) break;
            
            for (int d = 0; d < 4; d++) {
                int y = cur.y;
                int x = cur.x;
                while (true) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny].charAt(nx) == 'D') break;
                    y = ny;
                    x = nx;
                }
                
                if (visited[y][x] != 0) continue;
                visited[y][x] = visited[cur.y][cur.x] + 1;
                q.add(new Node(y, x));
            }
        }
        
        return visited[ey][ex] - 1;
    }
}