import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int sum = 0;
        int idx = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        while(idx < enemy.length) {
            if (sum + enemy[idx] <= n) {
                pq.add(enemy[idx]);
                sum += enemy[idx];
            } else {
                if (k != 0) {
                    if (pq.isEmpty() || enemy[idx] > pq.peek()) {
                        k--;
                    } else {
                        int x = pq.poll();
                        sum = sum - x + enemy[idx];
                        pq.add(enemy[idx]);
                        k--;
                    }
                } else {
                    break;
                }
            }
            
            idx++;
        }
        
        return idx;
    }
}