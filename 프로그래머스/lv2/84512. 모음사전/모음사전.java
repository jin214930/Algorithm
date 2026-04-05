import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    char[] vowel = {'A','E', 'I', 'O', 'U'};
    
    void go(String s) {
        if (s.length() > 5) return;
        
        if (s.length() != 0)
            list.add(s);
        
        for (int i = 0; i < 5; i++)
            go(s + vowel[i]);
    }
    
    public int solution(String word) {
        go("");
        
        for(int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i)))
                return i + 1;
        }
        
        return -1;
    }
}