import java.util.*;

class Solution {
    boolean[] visited;
    int[] cnt;
    List<Integer>[] adj;
    
    int dfs(int x) {
        visited[x] = true;
        int tmp = 1;
        
        for (int nx : adj[x]) {
            if (visited[nx]) continue;
            
            cnt[nx]++;
            tmp += dfs(nx);
        }
        
        return tmp;
    }
    
    public int solution(int n, int[][] results) {
        cnt = new int[n + 1];
        adj = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        
        for(int[] edge : results)
            adj[edge[0]].add(edge[1]);
        
        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            cnt[i] += dfs(i);
        }
        
        int ans = 0;
        for(int i = 1; i <=n; i++) {
            if (n == cnt[i])
                ans++;
        }
        
        return ans;        
    }
}