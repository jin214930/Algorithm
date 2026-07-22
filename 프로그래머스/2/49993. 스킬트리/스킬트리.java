import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        int ans = 0;
        for (String s : skill_trees) {
            int idx = 0;
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    if (map.get(c).equals(idx)) {
                        idx++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) ans++;
        }
        
        return ans;
    }
}