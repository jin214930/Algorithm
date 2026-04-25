import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String s = discount[i];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        if (check(map, want, number)) {
            ans++;
        }
        
        for (int i = 10; i < discount.length; i++) {
            String p = discount[i - 10];
            map.put(p, map.get(p) - 1);
            String s = discount[i];
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (check(map, want, number)) {
                ans++;
            }
        }
        
        return ans;
    }
    
    boolean check(Map<String, Integer> map, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            String s = want[i];
            if (!map.containsKey(s) || map.get(s) < number[i]) {
                return false;
            }
        }
        
        return true;
    }
}