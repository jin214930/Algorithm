import java.util.*;

class Node {
    int y, x;
    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int i = y1; i <= y2; i++) {
                for(int j = x1; j <= x2; j++) {
                    if (i == y1 || i == y2 || j == x1 || j == x2) {
                        if (map[i][j] != 2)
                            map[i][j] = 1;
                    } else
                        map[i][j] = 2;
                }
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[101][101];
        q.add(new Node(characterY * 2, characterX * 2));
        visited[characterY * 2][characterX * 2] = 1;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            if (node.y == itemY * 2 && node.x == itemX * 2) break;
            
            for(int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if(ny <0 || nx < 0 || ny > 100 || nx > 100) continue;
                if(map[ny][nx] != 1 || visited[ny][nx] != 0) continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[node.y][node.x] + 1;
            }
        }
        
        return visited[itemY * 2][itemX * 2] / 2;
    }
}