import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        int idx = 0;
        for(int[] i : commands) {
            int[] tmp = new int[i[1] - i[0] + 1];
            for(int j = i[0] - 1; j < i[1]; j++)
                tmp[j - i[0]+1] = array[j];
            Arrays.sort(tmp);
            ans[idx++] = tmp[i[2]-1];
        }
        
        return ans;
    }
}