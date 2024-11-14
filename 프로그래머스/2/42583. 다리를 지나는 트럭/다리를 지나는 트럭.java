import java.util.*;

class Solution {    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        int sum = 0;
        int i = 0;
        while (i < truck_weights.length) {
            ans++;
            if (!q.isEmpty() && q.peek() + bridge_length == ans) {
                sum -= truck_weights[i - q.size()];
                q.poll();
            }
            
            if (q.size() < bridge_length && sum + truck_weights[i] <= weight) {
                q.add(ans);
                sum += truck_weights[i++];
            }
        }
        
        ans += bridge_length;
        
        return ans;
    }
}