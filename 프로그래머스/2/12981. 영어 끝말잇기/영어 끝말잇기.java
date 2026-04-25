import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char c = '\0';
        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i]) || (i != 0 && c != words[i].charAt(0))) {
                return new int[]{i%n + 1, i / n + 1};
            }
            set.add(words[i]);
            c = words[i].charAt(words[i].length() - 1);
        }
            
        return new int[]{0, 0};
    }
}