import java.util.*;

class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    
    int dfs(int x, int y) {
        int tmp = 1;
        visited[x] = true;
        for (int nx : adj[x]) {
            if (visited[nx]) continue;
            if (nx == y) continue;
            tmp += dfs(nx, y);
        }
        
        return tmp;
    }
    
    public int solution(int n, int[][] wires) {
        adj = new ArrayList[n + 1];
        
        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        
        for(int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        int ans = 100000;
        
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            int tmp1 = dfs(wire[0], wire[1]);
            visited = new boolean[n + 1];
            int tmp2 = dfs(wire[1], wire[0]);
            
            ans = Math.min(ans, Math.abs(tmp1 - tmp2));
        }
        
        return ans;
    }
}