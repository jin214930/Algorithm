import java.util.*;

class Solution {
    class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        Queue<Node> q = new LinkedList<>();
        int ey = -1, ex = -1;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    q.add(new Node(i, j));
                    visited[i][j] = 1;
                } else if (board[i].charAt(j) == 'G') {
                    ey = i;
                    ex = j;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == ey && cur.x == ex) break;
            for (int i = 0; i < 4; i++) {
                int ny = cur.y;
                int nx = cur.x;
                while(true) {
                    int ty = ny + dy[i];
                    int tx = nx + dx[i];
                    if (ty < 0 || tx < 0 || ty >= n || tx >= m || board[ty].charAt(tx) == 'D') break;
                    ny = ty;
                    nx = tx;
                }
                if (visited[ny][nx] != 0) continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
            }
        }
        
        return visited[ey][ex] - 1;
    }
}