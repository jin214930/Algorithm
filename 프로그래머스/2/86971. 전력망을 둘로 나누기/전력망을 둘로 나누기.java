import java.util.*;

class Solution {
    List<List<Integer>> adj;
    boolean[] visited;
    
    public int dfs(int x) {
        int cnt = 1;
        visited[x] = true;
        for(int nx : adj.get(x)) {
            if (!visited[nx])
               cnt += dfs(nx); 
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        int ans = 1000000000;
        
        for (int i = 0; i < wires.length; i++) {
            adj = new ArrayList<>();
            for (int j = 0; j <= n; j++)
                adj.add(new ArrayList<>());
            visited = new boolean[n + 1];
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                adj.get(wires[j][0]).add(wires[j][1]);
                adj.get(wires[j][1]).add(wires[j][0]);
            }
            
            int[] tmp = new int[2];
            int idx = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) 
                    tmp[idx++] = dfs(j);
            }
            ans = Math.min(ans, Math.abs(tmp[0] - tmp[1]));
        }
        
        return ans;
    }
}