import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5}, 
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] cnt = new int[3];
        
        for (int i = 0; i < 3; i++) {
            int idx = 0;
            for (int answer : answers) {
                if (answer == pattern[i][idx])
                    cnt[i]++;
                idx = (idx + 1) % pattern[i].length;
            }
        }
        
        int mx = 0;
        for (int i : cnt)
            mx = Math.max(mx, i);
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (mx == cnt[i])
                list.add(i + 1);
        }
        
        Collections.sort(list);
        
        int[] ans = new int[list.size()];
        int idx = 0;
        for (int i : list)
            ans[idx++] = i;
        
        return ans;        
    }
}