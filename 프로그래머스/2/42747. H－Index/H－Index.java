import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i])
                ans = Math.max(ans, citations.length - i);
        }
        
        return ans;
    }
}