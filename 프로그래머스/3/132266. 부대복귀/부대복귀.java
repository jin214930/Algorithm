import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        int[] ans = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            Queue<Integer> q = new LinkedList<>();
            int[] visited = new int[n + 1];
            q.add(source);
            visited[source] = 1;
            
            while(!q.isEmpty()) {
                int x = q.poll();
                if (x == destination) break;
                for (int nx : adj.get(x)) {
                    if (visited[nx] != 0) continue;
                    q.add(nx);
                    visited[nx] = visited[x] + 1;
                }
            }
            ans[i] = visited[destination] - 1;
        }
        
        return ans;
    }
}