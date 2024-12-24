import java.util.*;

public class Solution {
    public int[] solution(int []a) {
        Stack<Integer> st = new Stack<>();
        
        for (int i : a) {
            if (st.isEmpty() || st.peek() != i)
                st.push(i);
        }
        
        int[] ans = new int[st.size()];
        while (!st.isEmpty()) {
            ans[st.size() - 1] = st.pop();
        }
        
        return ans;
    }
}