import java.util.*;

class Solution {
    String[] vowel = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        go(0, "");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) return i + 1;
        }
        return -1;
    }
    
    void go(int depth, String tmp) {
        if (tmp.length() > 0) list.add(tmp);
        if (depth == 5) return;
        for (int i = 0; i < 5; i++) {
            go(depth + 1, tmp + vowel[i]);
        }
    }
}