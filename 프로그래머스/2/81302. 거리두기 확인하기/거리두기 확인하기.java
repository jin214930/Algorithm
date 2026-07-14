import java.util.*;

class Point {
    int y, x;
    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] ans = new int[5];
        for (int p = 0; p < 5; p++) {
            List<Point> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[p][i].charAt(j) == 'P') list.add(new Point(i, j));
                }
            }
            
            int tmp = 1;
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    Point p1 = list.get(i);
                    Point p2 = list.get(j);
                    int d = getDist(p1, p2);
                    if (d > 2) continue;
                    if (check(p1, p2, places[p])) tmp = 0;
                }
            }
            
            ans[p] = tmp;
        }
        
        return ans;
    }
    
    int getDist(Point p1, Point p2) {
        return Math.abs(p1.y - p2.y) + Math.abs(p1.x - p2.x);
    }
    
    boolean check(Point p1, Point p2, String[] place) {
        Queue<Point> q = new LinkedList<>();
        int[][] visited = new int[5][5];
        for (int i = 0; i < 5; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
        q.add(p1);
        visited[p1.y][p1.x] = 1;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
                if (visited[ny][nx] != Integer.MAX_VALUE || place[ny].charAt(nx) == 'X') continue;
                q.add(new Point(ny, nx));
                visited[ny][nx] = visited[p.y][p.x] + 1;
            }
        }
        return visited[p2.y][p2.x] <= 3;
    }
}