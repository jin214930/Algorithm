import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);
        
        int ans = 0;
        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(s1 + 2 * s2);
            ans++;
        }
        
        return ans;
    }
}