import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && st.peek() == c) {
                st.pop();
                continue;
            }
            st.push(c);
        }
        if(st.isEmpty())
            return 1;
        return 0;
    }
}