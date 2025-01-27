import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int ans = 0;
        
        Arrays.sort(score);
        
        for (int i = score.length - 1; i >= 0; i -= m) {
            int tmp = k;
            if (i - m + 1 < 0)
                break;
            for (int j = 0; j < m; j++)
                tmp = Math.min(tmp, score[i - j]);
            ans += tmp * m;
            
        }
        
        return ans;
    }
}