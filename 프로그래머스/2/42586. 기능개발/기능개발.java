import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] daysToComplete = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int work = 100 - progresses[i];
            daysToComplete[i] = (work / speeds[i]) + (work % speeds[i] == 0 ? 0 : 1);
        }
        
        List<Integer> ansList = new ArrayList<>();
        int now = 0;
        int cnt = 0;
        for (int i : daysToComplete) {
            if (i <= now)
                cnt++;
            else {
                if (now != 0)
                    ansList.add(cnt);
                now = i;
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