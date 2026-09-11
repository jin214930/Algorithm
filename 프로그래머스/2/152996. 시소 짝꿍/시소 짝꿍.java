import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Long> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }
        
        long ans = 0;
        
        for (int w : map.keySet()) {
            long cnt = map.get(w);
            
            ans += cnt * (cnt - 1) / 2;
            
            if (w % 2 == 0) {
                int tmp = w * 3 / 2;
                if (map.containsKey(tmp)) {
                    ans += cnt * map.get(tmp);
                }
            }
            
            if (w % 3 == 0) {
                int tmp = w * 4 / 3;
                if (map.containsKey(tmp)) {
                    ans += cnt * map.get(tmp);
                }
            }
            
            int tmp = w * 2;
            if (map.containsKey(tmp)) {
                ans += cnt * map.get(tmp);
            }
        }
        
        return ans;
    }
}