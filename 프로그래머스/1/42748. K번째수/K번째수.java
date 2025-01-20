import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        int idx = 0;
        
        for (int[] command : commands) {
            List<Integer> list = new ArrayList<>();
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;
            
            for (int l = i; l <= j; l++)
                list.add(array[l]);
            
            Collections.sort(list);
            ans[idx++] = list.get(k);
        }
        
        return ans;
    }
}