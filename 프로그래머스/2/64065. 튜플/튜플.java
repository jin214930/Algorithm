import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] cnt = new int[100001];
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else if (sb.length() != 0) {
                int x = Integer.parseInt(sb.toString());
                cnt[x]++;
                sb.setLength(0);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            if (cnt[i] != 0) list.add(i);
        }
        
        Collections.sort(list, (x1, x2) -> {
            return cnt[x2] - cnt[x1];
        });
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}