import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (check(s))
                ans++;
        }
        
        return ans;
    }
    
    public boolean check(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else if (c == ')' && !st.isEmpty() && st.peek() == '(')
                st.pop();
            else if (c == '}' && !st.isEmpty() && st.peek() == '{')
                st.pop();
            else if (c == ']' && !st.isEmpty() && st.peek() == '[')
                st.pop();
            else
                st.push(c);
        }
        
        return st.isEmpty();
    }
}