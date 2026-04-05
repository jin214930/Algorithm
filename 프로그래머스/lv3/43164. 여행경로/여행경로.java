import java.util.*;

class Solution {
    boolean[] used;
    List<String> list = new ArrayList<>();
    
    void dfs(String[][] tickets, String tmp, int depth) {
        if (depth == tickets.length) {
            list.add(tmp);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if (used[i]) continue;
            if (tmp.endsWith(tickets[i][0])) {
                used[i] = true;
                dfs(tickets, tmp + tickets[i][1], depth + 1);
                used[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];

        dfs(tickets, "ICN", 0);
        
        Collections.sort(list);
        
        String[] ans = new String[tickets.length + 1];
        for(int i = 0; i < ans.length; i++) {
            String s = list.get(0);
            ans[i] = s.substring(3*i, 3*i + 3);
        }
        
        return ans;
    }
}