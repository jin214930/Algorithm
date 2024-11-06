import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int ans = nums.length / 2;
        
        HashSet<Integer> s = new HashSet<>();
        for (int i : nums)
            s.add(i);
        
        ans = Math.min(ans, s.size());
        return ans;
    }
}