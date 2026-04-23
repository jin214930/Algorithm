import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] cnt = new int[10000001];
        for (int t : tangerine) {
            cnt[t]++;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000000; i++) {
            if (cnt[i] != 0)
                list.add(cnt[i]);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        int idx = 0, ans = 0;
        while(k > 0) {
            k -= list.get(idx);
            idx++;
            ans++;
        }
        
        return ans;        
    }
}