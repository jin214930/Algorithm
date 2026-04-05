import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        for (int work : works) {
            sum += work;
        }
        
        if (sum <= n) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        
        for (int i = 0; i < n; i++) {
            int x = pq.poll();
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