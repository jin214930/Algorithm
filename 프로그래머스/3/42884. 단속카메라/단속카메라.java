import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        System.out.println(Arrays.deepToString(routes));

        int ans = 1;
        int tmp = routes[0][1];
        for (int[] i : routes) {
            if (i[0] > tmp) {
                tmp = i[1];
                ans++;
            }
            else if (i[1] < tmp)
                tmp = i[1];
        }
        
        return ans;
    }
}