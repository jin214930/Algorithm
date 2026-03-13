import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        
        for (String gem : gems)
            set.add(gem);
        
        int n = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int len = 100001;
        int[] ans = new int[2];
        
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while (map.size() == n) {
                if (end - start < len) {
                    len = end - start;
                    ans[0] = start + 1;
                    ans[1] = end + 1;
                }
                
                String tmp = gems[start];
                map.put(tmp, map.get(tmp) - 1);

                if (map.get(tmp) == 0)
                    map.remove(tmp);

                start++;
            }
        }
        
        return ans;
    }
}