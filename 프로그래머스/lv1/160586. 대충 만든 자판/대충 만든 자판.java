import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, 1000);
        
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++)
                alpha[s.charAt(i) - 'A'] = Math.min(alpha[s.charAt(i) - 'A'], i + 1);
        }
        
        int[] ans = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int tmp = 0;
            boolean flag = false;
            for (char c : targets[i].toCharArray()) {
                if (alpha[c - 'A'] == 1000) {
                    tmp = -1;
                    flag = true;
                    break;
                }
                tmp += alpha[c - 'A'];
            }
            if (flag) {
                ans[i] = -1;
                continue;
            }
            ans[i] = tmp;
        }
        
        return ans;
    }
}