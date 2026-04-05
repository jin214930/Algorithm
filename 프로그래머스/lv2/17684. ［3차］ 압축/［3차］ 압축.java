import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            map.put(String.valueOf(c), i + 1);
        }
        
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        while (idx < msg.length()) {
            String s = "";
            while(idx < msg.length()) {
                String c = String.valueOf(msg.charAt(idx));
                if (map.containsKey(s + c)) {
                    s += c;
                    idx++;
                } else {
                    map.put(s + c, map.size() + 1);
                    break;
                }
            }
            
            list.add(map.get(s));
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}