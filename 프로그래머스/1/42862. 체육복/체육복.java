import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] a = new int[n + 1];
        Arrays.fill(a, 1);
        
        for (int i : lost)
            a[i]--;
        for (int i : reserve)
            a[i]++;
        
        for (int i = 1; i <= n; i++) {
            if (a[i] == 0) {
                if (i >= 2 && a[i - 1] == 2) {
                    a[i - 1] = 1;
                    a[i] = 1;
                } else if (i <= n - 1 && a[i + 1] == 2) {
                    a[i + 1] = 1;
                    a[i] = 1;
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n ;i++) {
            if (a[i] >= 1)
                ans++;
        }
        
        return ans;
    }
}