import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] ans = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);
        
        for (int i = 0; i < photo.length; i++) {
            for (String s : photo[i]) {
                if (map.containsKey(s))
                    ans[i] += map.get(s);
            } 
        }
        
        return ans;
    }
}