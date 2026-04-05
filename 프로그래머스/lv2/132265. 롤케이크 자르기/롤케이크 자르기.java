import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int ans = 0;
        
        Map<Integer, Integer> map = new HashMap();
        Set set = new HashSet();
        
        for (int t : topping) 
            map.put(t, map.getOrDefault(t, 0) + 1);
        
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0)
                map.remove(topping[i]);
            if (set.size() == map.size())
                ans++;
        }
        
        return ans;        
    }
}