import java.util.*;

class Solution {
    boolean[] used;
    boolean flag;
    List<String> list = new ArrayList<>();
    
    void dfs(String s, String[][] tickets) {
        list.add(s);
        
        if (list.size() == tickets.length + 1) {
            flag = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(s) && !used[i]) {
                used[i] = true;
                dfs(tickets[i][1], tickets);
                if (flag)
                    return;
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        used = new boolean[tickets.length];
        
        dfs("ICN", tickets);
        
        String[] ans = new String[list.size()];
        int idx = 0;
        for (String s : list)
            ans[idx++] = s;
        
        return ans;
    }
}