import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> timeMap = new TreeMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] tmp = records[i].split(" ");
            String t = tmp[0];
            String n = tmp[1];
            String cmd = tmp[2];
            if (cmd.equals("IN")) {
                map.put(n, t);
            } else {
                int time = calTime(map.get(n), t);
                timeMap.put(n, timeMap.getOrDefault(n, 0) + time);
                map.remove(n);
            }
        }
        
        for (String n : map.keySet()) {
            int time = calTime(map.get(n), "23:59");
            timeMap.put(n, timeMap.getOrDefault(n, 0) + time);
        }
        
        int[] ans = new int[timeMap.size()];
        int idx = 0;
        for (String n : timeMap.keySet()) {
            ans[idx++] = calFee(timeMap.get(n), fees);
        }
        
        return ans;
    }
    
    int calTime(String s, String e) {
        int sInt = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
        int eInt = Integer.parseInt(e.substring(0, 2)) * 60 + Integer.parseInt(e.substring(3));
        return eInt - sInt;
    }
    
    int calFee(int time, int[] fees) {
        if (time <= fees[0]) {
            return fees[1];
        } else {
            return fees[1] + fees[3] * ((time - fees[0] + fees[2] - 1) / fees[2]);
        }
    }
}