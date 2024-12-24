import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int work = 100 - progresses[i];
            days[i] = (work / speeds[i]) + (work % speeds[i] == 0 ? 0 : 1);
        }
        
        List<Integer> ansList = new ArrayList<>();
        int now = 0;
        int cnt = 0;
        for (int d : days) {
            if (d <= now)
                cnt++;
            else {
                if (now != 0)
                    ansList.add(cnt);
                now = d;
                cnt = 1;
            }
        }
        ansList.add(cnt);
        
        int[] ans = new int[ansList.size()];
        int idx = 0;
        for (int i : ansList)
            ans[idx++] = i;
        
        return ans;
    }
}