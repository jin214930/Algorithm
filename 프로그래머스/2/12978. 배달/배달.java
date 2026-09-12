import java.util.*;

class Solution {
    static class Node {
        int v, w;
        
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    public int solution(int n, int[][] road, int k) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            adj.get(r[0]).add(new Node(r[1], r[2]));
            adj.get(r[1]).add(new Node(r[0], r[2]));
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
        dist[1] = 0;
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.v] < cur.w) continue;
            
            for (Node next : adj.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k) ans++;
        }
        
        return ans;
    }
}