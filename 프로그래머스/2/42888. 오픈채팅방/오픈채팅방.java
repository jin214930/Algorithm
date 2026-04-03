import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        
        for (String s : record) {
            String[] tmp = s.split(" ");
            String cmd = tmp[0];
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                map.put(tmp[1], tmp[2]);
            }
        }
        
        List<String> list = new ArrayList<>();
        for (String s : record) {
            String[] tmp = s.split(" ");
            if (tmp[0].equals("Enter")) {
                String nickname = map.get(tmp[1]);
                list.add(nickname + "님이 들어왔습니다.");
            } else if (tmp[0].equals("Leave")) {
                String nickname = map.get(tmp[1]);
                list.add(nickname + "님이 나갔습니다.");
            }
        }
        
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}