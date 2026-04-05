import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        
        for(int i = 0; i < arr.length; i++) {
            int remain = 100 - progresses[i];
            arr[i] = remain / speeds[i] + (remain % speeds[i] > 0 ? 1 : 0);
        }
        
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        int tmp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= tmp)
                cnt++;
            else {
                tmp = arr[i];
                list.add(cnt);
                cnt = 1;
            }
        }
        
        list.add(cnt);
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
}