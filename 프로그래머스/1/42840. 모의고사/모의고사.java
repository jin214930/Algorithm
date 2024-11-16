import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] a = { { 1, 2, 3, 4, 5 }, 
                     { 2, 1, 2, 3, 2, 4, 2, 5 }, 
                     { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } 
                    };

        int[] cnt = new int[3];
        for (int i = 0; i < 3; i++) {
            int idx = 0;
            for (int j : answers) {
                if (idx == a[i].length)
                    idx = 0;
                if (j == a[i][idx++])
                    cnt[i]++;
            }
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        int mx = 0;
        for (int i : cnt)
            mx = Math.max(i, mx);
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == mx)
                al.add(i + 1);
        }
        
        int idx = 0;
        int[] ans = new int[al.size()];
        for (int i : al)
            ans[idx++] = i;
        return ans;
    }
}