import java.util.*;

class Solution {
    boolean[] p = new boolean[10000000];
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    
    public void go(String s, String numbers) {
        if (s.length() != 0) {
            int tmp = Integer.parseInt(s);
            if (!p[tmp])
                set.add(tmp);
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            go(s + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }
    
    public int solution(String numbers) {
        p[0] = true;
        p[1] = true;
        for (int i = 2; i < 10000000; i++) {
            if (!p[i]) {
                for (int j = i * 2; j < 10000000; j += i)
                    p[j] = true;
            }
        }
        
        visited = new boolean[numbers.length()];
        go("", numbers);

        return set.size();
    }

}