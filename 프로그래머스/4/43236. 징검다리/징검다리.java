import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int ans = 0;
        Arrays.sort(rocks);
        int a[] = new int[rocks.length + 2];
        a[0] = 0;
        a[a.length - 1] = distance;
        for(int i = 0; i < a.length - 2;i++)
            a[i + 1] = rocks[i]; 
        int s = 1, e = distance;
        while(s <= e) {
            int m = (s + e) / 2;
            if(check(a, m, n)) {
                ans = m;
                s = m + 1;
            }
            else
                e = m - 1;
        }
        return ans;
    }
    
    public boolean check(int[] a, int m, int n) {
        int idx = 0, cnt = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i] - a[idx] < m) {
                cnt++;
                continue;
            }
            idx = i;
        }
        return cnt <= n;
    }
}