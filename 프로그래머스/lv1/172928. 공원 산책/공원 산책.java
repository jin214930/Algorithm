import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int dy[] = {1, -1, 0, 0};
        int dx[] = {0, 0, 1, -1};
        Map<String, Integer> map = new HashMap<>();
        map.put("S", 0);
        map.put("N", 1);
        map.put("E", 2);
        map.put("W", 3);
        
        
        int y = 0, x = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    y = i;
                    x = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] tmp = route.split(" ");
            String op = tmp[0];
            int n = Integer.parseInt(tmp[1]);
            int d = map.get(op);
            
            boolean flag = false;
            int ny = y;
            int nx = x;
            while (n-- > 0) {
                ny = ny + dy[d];
                nx = nx + dx[d];
                if (ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length() || park[ny].charAt(nx) == 'X') {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            y = ny;
            x = nx;
        }
        
        int[] ans = new int[2];
        ans[0] = y;
        ans[1] = x;
        return ans;
    }
}