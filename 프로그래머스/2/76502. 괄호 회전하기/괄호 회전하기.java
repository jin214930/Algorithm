import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String p = s.substring(i) + s.substring(0, i);
            if (check(p)) {
                ans++;
            }
        }
        
        return ans;
    }
    
    boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else if (c == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            } else if (c == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            } else {
                return false;
            }
        }
        
        return st.isEmpty();
    }
}