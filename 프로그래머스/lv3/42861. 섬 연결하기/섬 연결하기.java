import java.util.*;

class Edge {
    int v, c;
    
    Edge(int v, int c) {
        this.v = v;
        this.c = c;
    }
}

class Solution {    
    public int solution(int n, int[][] costs) {
        int ans = 0;
        
        List<Edge>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
        
        for (int[] cost : costs) {
            adj[cost[0]].add(new Edge(cost[1], cost[2]));
            adj[cost[1]].add(new Edge(cost[0], cost[2]));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) ->{
            return e1.c - e2.c;
        });
        pq.add(new Edge(0, 0));
        
        int cnt = 0;
        while(cnt != n) {
            Edge e = pq.poll();
            if (visited[e.v]) continue;
            
            visited[e.v] = true;
            ans += e.c;
            cnt++;
            
            for (Edge ne : adj[e.v]) {
                if (!visited[ne.v]) {
                    pq.add(ne);
                }
            }
        }
        return ans;
    }
}