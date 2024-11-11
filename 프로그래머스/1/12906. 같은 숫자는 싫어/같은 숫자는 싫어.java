import java.util.*;

public class Solution {
    public int[] solution(int []a) {
        Stack<Integer> st = new Stack<>();
        for (int i : a) {
            if (!st.isEmpty() && st.peek() == i)
                continue;
            else 
                st.push(i);
        }
        
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0;i--)
            ans[i] = st.pop();
        
        return ans;
    }
}