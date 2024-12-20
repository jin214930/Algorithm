import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> mp = new HashMap<>();
        
        for (String s : completion) {
            if (mp.containsKey(s))
                mp.put(s, mp.get(s) + 1);
            else
                mp.put(s, 1);
        }
        
        for (String s : participant) {
            if (mp.containsKey(s) && mp.get(s) != 0)  
                mp.put(s, mp.get(s) - 1);
            else 
                return s;            
        }
        
        return "";
    }
}