import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n + 1];
        q.add(destination);
        visited[destination] = 1;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            for (int nx : adj.get(x)) {
                if (visited[nx] != 0) continue;
                q.add(nx);
                visited[nx] = visited[x] + 1;
            }
        }
        
        int[] ans = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            ans[i] = visited[sources[i]] - 1;
        }
        
        return ans;
    }
}