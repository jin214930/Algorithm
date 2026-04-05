import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        for (int c : course) {
            for (String o : orders) {
                if (o.length() >= c)
                    go("", o, c, 0);
            }
        }
        
        List<String> list = new ArrayList<>();
        for (int c : course) {
            int max = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().length() == c) {
                    max = Math.max(max, entry.getValue());
                }
            }
            
            if (max >= 2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getKey().length() == c && entry.getValue() == max) {
                        list.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(list);
        
        String[] ans = new String[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;              
    }

    void go(String s, String o, int c, int idx) {
        if (s.length() == c) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        
        for (int i = idx; i < o.length(); i++) {
            go(s + o.charAt(i), o, c, i + 1);
        }
    }
}