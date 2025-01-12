import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville)
            pq.add(s);
        
        int ans = 0;
        while (true) {
            if (pq.size() == 1 && pq.peek() < K)
                return -1;
            int s1 = pq.poll();
            if (s1 >= K)
                break;
            int s2 = pq.poll();
            pq.add(s1 + s2 * 2);
            ans++;
        }
        
        return ans;
    }
}