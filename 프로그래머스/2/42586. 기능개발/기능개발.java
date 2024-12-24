import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ansList = new ArrayList<>();
        int now = 0;
        int cnt = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int work = 100 - progresses[i];
            int day = (work / speeds[i]) + (work % speeds[i] == 0 ? 0 : 1);
            if (day > now) {
                if (now != 0)
                    ansList.add(cnt);
                now = day;
                cnt = 1;
            } else 
                cnt++;
        }
        ansList.add(cnt);
        
        int[] ans = new int[ansList.size()];
        int idx = 0;
        for (int i : ansList)
            ans[idx++] = i;
        
        return ans;
    }
}