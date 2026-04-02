import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        boolean[] spo = new boolean[message.length()];
        
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                spo[i] = true;
            }
        }
        
        String[] words = message.split(" ");
        int idx = 0;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (String word : words) {
            boolean flag = true;
            for (int i = idx; i < word.length() + idx; i++) {
                if (spo[i]) {
                    set1.add(word);
                    flag = false;
                    break;
                }
            }
            if (flag) 
                set2.add(word);
            
            idx = idx + word.length() + 1;
        }
        
        int ans = 0;
        for (String s : set1) {
            if (set2.contains(s)) continue;
            ans++;
        }

        return ans;
    }
}