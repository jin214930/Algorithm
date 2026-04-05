import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int mx = citations[citations.length - 1];
        
        for(int i = mx; i >= 0; i--) {
            int cnt = 0;
            for(int j = 0; j < citations.length; j++) {
                if (citations[j] >= i)
                    cnt++;
            }
            
            if (cnt >= i)
                return i;
        }
        
        return 0;
    }
}