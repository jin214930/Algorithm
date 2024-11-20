import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<ArrayList<Integer>> adj;
    
    int dfs(int x) {
        visited[x] = true;
        int cnt = 1;
        for (int nx : adj.get(x)) {
            if (visited[nx])
                continue;
            cnt += dfs(nx);
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        int ans = 1000000000;
        
        for (int i = 0; i < n - 1; i++) {
            adj = new ArrayList<>();
            for (int j = 0; j <= n; j++) 
                adj.add(new ArrayList<>());
            for (int j = 0; j < n - 1; j++) {
                if (i == j)
                    continue;
                adj.get(wires[j][0]).add(wires[j][1]);
                adj.get(wires[j][1]).add(wires[j][0]);
            }
            
            visited = new boolean[n + 1];
            int tmp = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if(tmp == 0)
                        tmp = dfs(j);
                    else
                        tmp = Math.abs(tmp - dfs(j));
                }
            }
            ans = Math.min(ans, tmp);
        }
        
        return ans;
    }
}