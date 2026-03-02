import java.util.*;

class Solution {
    boolean[] p = new boolean[10000001];
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    void go(String s, String tmp) {
        if (tmp.length() != 0) {
            int x = Integer.parseInt(tmp);
            if (!p[x])
                set.add(x);
        }
        
        for(int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            go(s, tmp + s.charAt(i));
            visited[i] = false;
        }
    }
    
    
    public int solution(String numbers) {
        p[0] = true;
        p[1] = true;
        for(int i = 2; i <= 10000000; i++) {
            if (p[i]) continue;
            for(int j = i * 2; j<= 10000000; j += i)
                p[j] = true;
        }
        
        visited = new boolean[numbers.length()];
        
        go(numbers, "");
        
        return set.size();
    }
}