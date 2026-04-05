import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville)
            pq.add(i);
        
        int ans = 0;
        while(pq.peek() < K) {
            if (pq.size() == 1)
                return -1;
            int x = pq.poll();
            int y = pq.poll();
            pq.add(x + 2 * y);
            ans++;
        }
        
        return ans;
    }
}