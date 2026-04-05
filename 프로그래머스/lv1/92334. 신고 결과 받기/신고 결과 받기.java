import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : id_list) 
            map.put(s, new HashSet<>());
        
        for (String s : report) {
            String[] tmp = s.split(" ");
            if (map.get(tmp[0]).add(tmp[1])) 
                cnt.put(tmp[1], cnt.getOrDefault(tmp[1], 0) + 1);
        }
        
        int[] ans = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            for (String t : map.get(id_list[i])) {
                if (cnt.containsKey(t) && cnt.get(t) >= k) {
                    ans[i]++;
                }
            }
        }
        
        return ans;      

    }
}