import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int ans = 0;
        Arrays.sort(d);
        for(int i : d) {
            if(i > budget) 
                break;
            budget -= i;
            ans++;
        }
        return ans;
    }
}