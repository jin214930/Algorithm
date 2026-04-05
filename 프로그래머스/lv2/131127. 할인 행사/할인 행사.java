import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        
        for (int i = 0; i < 10; i++) 
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        
        for (int i = 9; i < discount.length; i++) {
            if (i != 9) {
                map.put(discount[i - 10], map.get(discount[i - 10]) - 1);
                map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            }
            boolean flag = true;
            for (int j = 0; j < want.length; j++) {
                if (map.containsKey(want[j]) && map.get(want[j]) >= number[j]) {
                    continue;
                }
                flag = false;
                break;
            }

            if (flag)
                ans++;
        }
        
        return ans;
    }
}