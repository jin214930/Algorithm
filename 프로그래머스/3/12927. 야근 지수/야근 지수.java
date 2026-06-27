import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) pq.add(work);
        
        for (int i = 0; i < n; i++) {
            int x = pq.poll();
            if (x == 0) return 0;
            pq.add(x - 1);
        }
        
        long ans = 0;
        while(!pq.isEmpty()) {
            int x = pq.poll();
            ans += x * x;
        }
        
        return ans;
    }
}