import java.util.*;

class Solution {
    public boolean check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        
        return cnt == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        
        q.add(begin);
        map.put(begin, 1);
        
        while(!q.isEmpty()) {
            String s = q.poll();
            if (s.equals(target)) break;
            for(String word : words) {
                if (map.containsKey(word)) continue;
                if (!check(s, word)) continue;
                q.add(word);
                map.put(word, map.get(s) + 1);
            }
        }
        
        if (map.containsKey(target))
            return map.get(target) - 1;
        
        return 0;
    }
}