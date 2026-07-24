import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int x : queue1) {
            q1.add(x);
            sum1 += x;
        }
        for (int x : queue2) {
            q2.add(x);
            sum2 += x;
        }
        
        int ans = 0;
        for (int i = 0; i < (queue1.length + queue2.length) * 2; i++) {
            if (sum1 == sum2) {
                return ans;
            } else if (sum1 > sum2) {
                int x = q1.poll();
                sum1 -= x;
                sum2 += x;
                q2.add(x);
            } else {
                int x = q2.poll();
                sum2 -= x;
                sum1 += x;
                q1.add(x);
            }
            ans++;
        }
        
        return -1;
    }
}