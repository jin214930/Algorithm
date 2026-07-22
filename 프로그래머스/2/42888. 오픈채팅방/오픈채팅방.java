import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for (String s : record) {
            String[] tmp = s.split(" ");
            String cmd = tmp[0];
            String id = tmp[1];
            String name;
            if (cmd.equals("Enter")) {
                name = tmp[2];
                list.add(cmd + ":" + id);
                map.put(id, name);
            } else if (cmd.equals("Leave")) {
                list.add(cmd + ":" + id);
            } else {
                name = tmp[2];
                map.put(id, name);
            }
        }
        
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] tmp = s.split(":");
            String cmd = tmp[0];
            if (cmd.equals("Enter")) {
                ans[i] = map.get(tmp[1]) + "님이 들어왔습니다.";
            } else {
                ans[i] = map.get(tmp[1]) + "님이 나갔습니다.";
            }
        }
        
        return ans;
    }
}