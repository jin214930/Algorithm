import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> {
            if (r1[1] == r2[1])
                return r1[0] - r2[0];
            return r1[1] - r2[1];
        });
        
        int ans = 0;
        int tmp = -30000;
        for (int[] route : routes) {
            if (tmp < route[0]) {
                tmp = route[1];
                ans++;
            }
        }
        
        return ans;
    }
}