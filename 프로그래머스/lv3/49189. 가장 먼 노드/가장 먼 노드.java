import java.util.*;

class Solution {
    List<Integer>[] adj;
    
    public int solution(int n, int[][] edge) {
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) 
            adj[i] = new ArrayList<>();
        
        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n + 1];
        
        q.add(1);
        visited[1] = 1;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            
            for (int nx : adj[x]) {
                if(visited[nx] != 0) continue;
                q.add(nx);
                visited[nx] = visited[x] + 1;
            }
        }
        
        int mx = 0;
        for(int i = 1; i <= n; i++)
            mx = Math.max(mx, visited[i]);
        
        int ans = 0;
        for (int i = 1; i <=n;i++) {
            if (mx == visited[i])
                ans++;
        }
        
        return ans;
        
    }
}