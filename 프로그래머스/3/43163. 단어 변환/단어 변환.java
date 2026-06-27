import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        q.add(begin);
        visited.put(begin, 1);
        
        while(!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(target)) break;
            for (String s : words) {
                if (visited.containsKey(s) || !canChange(cur, s)) continue;
                q.add(s);
                visited.put(s, visited.get(cur) + 1);
            }
        }
        
        if (!visited.containsKey(target)) return 0;
        return visited.get(target) - 1;
        
    }
    
    boolean canChange(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        
        return cnt == 1;
    }
}