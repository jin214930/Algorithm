import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        int s = 0, e = people.length - 1;
        while(s <= e) {
            if(people[e] + people[s] <= limit) {
                cnt++;
                s++;
                e--;
            }
            else {
                cnt++;
                e--;
            }
        }
    

        return cnt;
    }
}