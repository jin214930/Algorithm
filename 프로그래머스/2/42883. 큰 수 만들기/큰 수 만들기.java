import java.util.*;

class Solution {
    public String solution(String number, int k) {        
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int len = number.length() - k;
        
        for (char c : number.toCharArray()) {
            while(!st.isEmpty() && st.peek() < c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        
        for (int i = 0; i < len; i++)
            sb.append(st.get(i));
            
        return sb.toString();
    }
}