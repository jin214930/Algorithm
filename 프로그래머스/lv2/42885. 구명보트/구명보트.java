import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int ans = 0;
        int idx = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (i < idx) break;
            if (people[i] + people[idx] <= limit) 
                idx++;
            ans++;
        }
        
        return ans;
    }
}