import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String c : completion) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        
        for (String p : participant) {
            if (map.containsKey(p) && map.get(p) > 0) 
                map.put(p, map.get(p) - 1);
            else
                return p;
        }
        
        return "";
    }
}