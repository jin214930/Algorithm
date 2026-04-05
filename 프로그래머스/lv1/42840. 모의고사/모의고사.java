import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] cnt = new int[3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < answers.length; j++) {
                if (patterns[i][j % patterns[i].length] == answers[j])
                    cnt[i]++;
            }
        }
        
        int mx = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3;i++) {
            if(mx== cnt[i])
                list.add(i + 1);
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}