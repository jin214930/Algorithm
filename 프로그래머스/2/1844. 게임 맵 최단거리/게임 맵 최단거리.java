import java.util.*;

class Node {
    int y, x;
    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    int[] dy = {0, 0, -1, 1};
    int[] dx = {1, -1, 0, 0};
    int[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(0, 0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if (maps[ny][nx] == 0 || visited[ny][nx] != 0) continue;
                
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[node.y][node.x] + 1;
            }
        }
        
        if (visited[n-1][m-1] == 0)
            return -1;
        return visited[n-1][m-1];
                
    }
}