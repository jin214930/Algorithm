import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        
        int mx = nums.length / 2;
        if (set.size() >= mx)
            return mx;
        else
            return set.size();
    }
}