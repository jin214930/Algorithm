import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) != i)
                list.add(i);
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
}