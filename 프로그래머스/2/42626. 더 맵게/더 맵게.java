import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville)
            pq.add(i);
        
        while (true) {
            int tmp1 = pq.poll();
            if (tmp1 >= K)
                break;
            if (pq.isEmpty())
                return -1;
            int tmp2 = pq.poll();
            pq.add(tmp1 + tmp2 * 2);
            ans++;
        }
        return ans;     
    }
}