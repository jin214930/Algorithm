import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i : arr) {
            if(i % divisor == 0)
                a.add(i);
        }
        Collections.sort(a);
        if(a.isEmpty()) {
            int[] ans = {-1};
            return ans;
        }
        int[] ans = new int[a.size()];
        int idx = 0;
        for(int i : a)
            ans[idx++] = i;
        
        return ans;
    }
}