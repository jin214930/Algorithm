import java.util.*;

class Solution {
    int ans = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        go(dungeons, k, new ArrayList<>());
        
        return ans;
    }
    
    void go(int[][] dungeons, int k, List<Integer> list) {
        if (list.size() == dungeons.length) {
            int cnt = 0;
            for (int i : list) {
                if (dungeons[i][0] > k) break;
                cnt++;
                k -= dungeons[i][1];
            }
            
            ans = Math.max(ans, cnt);
            
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(i);
            go(dungeons, k, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}