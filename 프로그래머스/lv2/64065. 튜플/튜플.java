import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '{') {
                flag = true;
            } else if (c == '}') {
                list.add(sb.toString());
                sb.setLength(0);
                flag = false;
            } else if (flag) {
                sb.append(c);
            }
        }
        
        Collections.sort(list, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        
        int[] ans = new int[list.size()];
        boolean[] check = new boolean[100001];
        
        for (int i = 0; i < list.size(); i++) {
            String[] tmp = list.get(i).split(",");
            for (String a : tmp) {
                int x = Integer.parseInt(a);
                if (check[x]) continue;
                check[x] = true;
                ans[i] = x;
            }
        }
                
        return ans;
    }
}