import java.util.*;

class Solution {
    class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {-1, 1, 0, 0};
    
    boolean check(String[] place) {
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0;j <5;j++) {
                if (place[i].charAt(j) == 'P')
                    list.add(new Node(i, j));
            }
        }
        
        if (list.isEmpty()) return true;
        
        for(Node node : list) {
            if (!bfs(node, place)) return false;
        }
        
        return true;             
    }
    
    boolean bfs(Node node, String[] place) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        q.add(node);
        visited[node.y][node.x] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny <0 || nx < 0 || ny >= 5 || nx >= 5) continue;
                if(place[ny].charAt(nx) == 'X' || visited[ny][nx]) continue;
                
                int d = Math.abs(node.y -ny) + Math.abs(node.x - nx);
                if(d > 2) continue;
                
                if (place[ny].charAt(nx) == 'P') return false;
                q.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }
        
        return true;
    }
    
    
    public int[] solution(String[][] places) {
        int[] ans = new int[5];
        for (int i = 0; i < 5; i++) {
            if (check(places[i]))
                ans[i] = 1;
        }
        
        return ans;
    }
}