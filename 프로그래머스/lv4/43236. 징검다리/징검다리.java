import java.util.*;

class Solution {
    boolean check(int m, int d, int[] rocks, int n) {
        int tmp = 0;
        int cnt = 0;
        for (int rock : rocks) {
            if (rock - tmp < m)
                cnt++;
            else
                tmp = rock;
        }
        
        if (d - tmp < m)
            cnt++;
        
        return cnt <= n;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int s = 1;
        int e = 1000000000;
        
        Arrays.sort(rocks);
        
        int ans = 0;
        while(s <= e) {
            int m = (s + e) / 2;
            if(check(m, distance, rocks, n)) {
                s = m + 1;
                ans = m;
            } else
                e = m - 1;
        }
        
        return ans;
    }
}