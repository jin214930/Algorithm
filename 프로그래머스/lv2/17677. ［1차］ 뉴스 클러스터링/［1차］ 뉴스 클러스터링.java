import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        int sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            char c1 = tmp.charAt(0);
            char c2 = tmp.charAt(1);
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') { 
                map1.put(tmp, map1.getOrDefault(tmp, 0) + 1);
                sum1++;
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            char c1 = tmp.charAt(0);
            char c2 = tmp.charAt(1);
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') { 
                map2.put(tmp, map2.getOrDefault(tmp, 0) + 1);
                sum2++;
            }
        }
        
        if (map1.size() == 0 && map2.size() == 0)
            return 65536;
        
        int cnt = 0;
        
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) 
                cnt += Math.min(map1.get(key), map2.get(key));
        }
        
        return (int) ((double)cnt / (sum1 + sum2 - cnt) * 65536);
        
        
    }
}