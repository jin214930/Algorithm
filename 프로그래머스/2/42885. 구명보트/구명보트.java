import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int l = 0, r = people.length - 1;
        int ans = 0;
        while (l <= r) {
            if (people[r] + people[l] <= limit) {
                l++;
            } 
            r--;
            ans++;
        }
        
        return ans;
    }
}