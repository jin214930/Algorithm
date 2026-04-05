import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        List<Integer>[] lists = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < signals[i][j]; k++)
                    lists[i].add(j);
            }
        }
        
        int maxT = 1;
        for (int i = 0; i < n;i++) {
            maxT *= lists[i].size();
        }
        
        for (int t = 0; t < maxT; t++) {
            int tmp = lists[0].get(t % lists[0].size());
            if (tmp != 1) continue;
            boolean flag = true;
            for (int i = 1; i < n; i++) {
                if (tmp != lists[i].get(t % lists[i].size())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return t + 1;
            }
        }
        
        return -1;
    }
}