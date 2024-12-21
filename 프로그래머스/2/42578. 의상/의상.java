import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> mp = new HashMap<>();
        
        for (String[] s : clothes) 
            mp.put(s[1], mp.getOrDefault(s[1], 0) + 1);
        
        int ans = 1;
        for (int i : mp.values())
            ans *= i + 1;
        
        return ans - 1;
    }
}