import java.util.*;

class Solution {    
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        for (String i : info) {
            String[] p = i.split(" ");
            makeCombi(p, "",  0);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        int[] ans = new int[query.length];
        
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", "");
            String[] qArr = q.split(" ");
            String key = qArr[0];
            int score = Integer.parseInt(qArr[1]);
            
            ans[i] = binarySearch(key, score);            
        }
        
        return ans;
    }
    
    void makeCombi(String[] info, String s, int depth) {
        if (depth == 4) {
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(Integer.parseInt(info[4]));
            return;
        }
        
        makeCombi(info, s + "-", depth + 1);
        makeCombi(info, s + info[depth], depth + 1);
    }
    
    int binarySearch(String key, int score) {
        if (!map.containsKey(key)) {
            return 0;
        }
        
        List<Integer> list = map.get(key);
        int s = 0;
        int e = list.size() - 1;
        
        while (s <= e) {
            int m = (s + e) / 2;
            
            if (list.get(m) < score) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        } 
        
        return list.size() - s;
    }
}