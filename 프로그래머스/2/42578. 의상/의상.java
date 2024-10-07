import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> mp = new HashMap<>();
        for(String[] i : clothes) {
            if(mp.containsKey(i[1]))
                mp.put(i[1], mp.get(i[1]) + 1);
            else
                mp.put(i[1], 1);
        }
        
        int ans = 1;
        for(int i : mp.values()) 
            ans *= i + 1;
        return ans - 1;
    }
}