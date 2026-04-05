import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++)
                set.add(numbers[i] + numbers[j]);
        }
        
        int[] ans = new int[set.size()];
        int idx = 0;
        for (int i : set)
            ans[idx++] = i;
        
        Arrays.sort(ans);
        
        return ans;
        
    }
}