import java.util.*;

class Solution {
    HashSet<HashSet<String>> ans = new HashSet<>();
    
    void go(int idx, HashSet<String> set, String[] user_id, String[] banned_id) {
        if (idx == banned_id.length) {
            ans.add(new HashSet<>(set));
            return;
        }
        
        String target = banned_id[idx];
        for(String s : user_id) {
            if (set.contains(s)) continue;
            
            if (match(s, target)) {
                set.add(s);
                go(idx + 1, set, user_id, banned_id);
                set.remove(s);
            }
        }
    }
    
    boolean match(String s, String target) {
        if (s.length() != target.length())
            return false;
        
        for (int i = 0; i < s.length(); i++) {
            if (target.charAt(i) != '*' && s.charAt(i) != target.charAt(i))
                return false;
        }
        
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        go(0, new HashSet<>(), user_id, banned_id);
        
        return ans.size(); 
    }
}