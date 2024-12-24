import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int ans = 0;
        for (int i = 0; i <= 10000; i++) {
            int cnt = 0;
            for (int c : citations) {
                if (i <= c)
                    cnt++;
            }
            
            if (cnt >= i)
                ans = i;
        }
        
        return ans;
    }
}