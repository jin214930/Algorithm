import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    String[] tmp = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        go("", -1);
        
        int ans = 0;
        for (String s : babbling) {
            if (set.contains(s))
                ans++;
        } 
        
        return ans;
    }
    
    public void go(String s, int idx) {
        if (s.length() > 30)
            return;
        set.add(s);
        
        for (int i = 0; i < 4; i++) {
            if (idx != i)
                go(s + tmp[i], i);
        }
    }
}