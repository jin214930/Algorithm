import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

        int ans = 1;
        int tmp = routes[0][1];
        for (int[] route : routes) {
            if (route[0] > tmp) {
                tmp = route[1];
                ans++;
            }
            else if (route[1] < tmp)
                tmp = route[1];
        }
        
        return ans;
    }
}