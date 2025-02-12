import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        while (set.size() != n) {
            int mn = 1000000000;
            int nx = -1;
            for (int[] cost : costs) {
                if (set.contains(cost[0]) && !set.contains(cost[1])) {
                    if (mn > cost[2]) {
                        mn = cost[2];
                        nx = cost[1];
                    }
                } 
                
                if (set.contains(cost[1]) && !set.contains(cost[0])) {
                    if (mn > cost[2]) {
                        mn = cost[2];
                        nx = cost[0];
                    }
                } 
            }
            
            set.add(nx);
            ans += mn;
        }
        
        return ans;        
    }
}