import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        
        while (!st.isEmpty()) {
                ans[st.peek()] = prices.length - 1 - st.peek();
                st.pop();
            }
        
        return ans;
        
    }
}