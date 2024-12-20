import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : completion) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }
        
        for (String s : participant) {
            if (map.containsKey(s) && map.get(s) > 0) 
                map.put(s, map.get(s) - 1);
            else
                return s;
        }
        
        return "";
    }
}