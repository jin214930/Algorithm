import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[1000001];
        
        q.add(x);
        visited[x] = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cur == y)
                break;
            
            for (int nx : new int[] {cur + n, 2 * cur, 3 * cur}) {
                if (nx > 1000000 || visited[nx] != 0) continue;
                q.add(nx);
                visited[nx] = visited[cur] + 1;
            }
        }
        
        return visited[y] - 1;
    }
}