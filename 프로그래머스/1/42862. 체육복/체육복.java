import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] tmp = new int[n + 1];
        
        Arrays.fill(tmp, 1);
        tmp[0] = 0;
        
        for (int i : lost)
            tmp[i] -= 1;
        for (int i : reserve)
            tmp[i] += 1;
        
        for(int i = 1; i <= n; i++) {
            if (tmp[i] == 0) {
                if (tmp[i - 1] == 2) {
                    tmp[i - 1] = 1;
                    tmp[i] = 1;
                } else if (i < n && tmp[i + 1] == 2) {
                    tmp[i + 1] = 1;
                    tmp[i] = 1;
                }
            }
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if (tmp[i] >= 1)
                ans++;
        }
        
        return ans;
    }
}