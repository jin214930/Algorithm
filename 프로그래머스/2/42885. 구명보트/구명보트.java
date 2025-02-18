import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int ans = 0;
        
        Arrays.sort(people);
        
        int s = 0, e = people.length - 1;
        while (s <= e) {
            if (people[e] + people[s] <= limit) {
                ans++;
                s++;
                e--;
            }
            else {
                ans++;
                e--;
            }
        }

        return ans;
    }
}