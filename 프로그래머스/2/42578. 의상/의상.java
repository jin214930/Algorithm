import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> mp = new HashMap<>();
        for(String[] s : clothes) {
            if(mp.containsKey(s[1])) {
                mp.put(s[1], mp.get(s[1]) + 1);
            }
            else
                mp.put(s[1], 1);
        }
        int ans = 1;
        for(String i : mp.keySet()) 
            ans *= mp.get(i) + 1;
        return ans - 1;
    }
}