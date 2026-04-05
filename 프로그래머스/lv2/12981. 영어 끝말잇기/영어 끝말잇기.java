import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] ans = new int[2];
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        int cnt = 1, tmp = 2;
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0) 
                && !set.contains(words[i])) {
                tmp++;
                if (tmp == n + 1) {
                    tmp = 1;
                    cnt++;
                }
                set.add(words[i]);
            }
            else {
                ans[0] = tmp;
                ans[1] = cnt;
                break;
            }
        }

        return ans;
    }
}