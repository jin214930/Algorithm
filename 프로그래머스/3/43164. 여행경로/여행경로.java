import java.util.*;

class Solution {
    boolean[] visited;
    int n;
    String[] ans;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (t1, t2) -> {
            return t1[1].compareTo(t2[1]);
        });
        
        n = tickets.length;
        ans = new String[n + 1];
        visited = new boolean[n];
        ans[0] = "ICN";
        go("ICN", 0, tickets);
        
        return ans;
    }
    
    boolean go(String cur, int depth, String[][] tickets) {
        if (depth == n) return true;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (tickets[i][0].equals(cur)) {
                visited[i] = true;
                ans[depth + 1] = tickets[i][1];
                if (go(tickets[i][1], depth + 1, tickets)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}