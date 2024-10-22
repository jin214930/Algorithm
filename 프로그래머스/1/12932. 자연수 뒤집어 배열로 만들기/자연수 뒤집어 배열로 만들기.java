import java.util.*;
class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> a = new ArrayList<>();
        while(n != 0) {
            a.add((int)(n % 10));
            n/=10;
        }
        int[] ans = new int[a.size()];
        int idx = 0;
        for(int i : a) {
            ans[idx++] = i;
        }
        return ans;
    }
}