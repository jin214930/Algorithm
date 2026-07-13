import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int ans = 0;
        int idx = 0;
        
        for (int a : A) {
            while(idx < B.length && B[idx] <= a) {
                idx++;
            }
            if (idx != B.length) {
                ans++;
                idx++;
            }
        }
        return ans;
    }
}