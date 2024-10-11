import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] a = new int[speeds.length];
        int cnt = 0, tmp = 0;
        for(int i = 0; i < a.length;i++) {
            
            a[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0)
                a[i]++;
            if(tmp == 0) {
                tmp = a[i];
                cnt = 1;
                continue;
            }
            if(a[i] > tmp) {
                tmp = a[i];
                al.add(cnt);
                cnt = 1;
            }
            else
                cnt++;
        }
        if(cnt != 0)
            al.add(cnt);
        
        int[] ans = new int[al.size()];
        int idx = 0;
        for(int i : al) 
            ans[idx++] = i;
        
        return ans;
    }
}