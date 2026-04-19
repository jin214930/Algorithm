import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int ans = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i : queue1) {
            sum1 += i;
            q1.add(i);
        }
        
        for (int i : queue2) {
            sum2 += i;
            q2.add(i);
        }
        
        while(sum1 != sum2) {
            if (ans > queue1.length * 4) {
                break;
            }
            
            if (sum1 > sum2) {
                int x = q1.poll();
                sum1 -= x;
                sum2 += x;
                q2.add(x);
            } else if (sum1 < sum2) {
                int x = q2.poll();
                sum2 -= x;
                sum1 += x;
                q1.add(x);
            }
            ans++;
        }
        
        if (sum1 != sum2) {
            ans = -1;
        }
        
        return ans;
    }
}