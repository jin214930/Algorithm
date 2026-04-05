import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        
        int[] ans = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            while(!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int idx = st.pop();
                ans[idx] = i - idx; 
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            int idx = st.pop();
            ans[idx] = prices.length - idx - 1;
        }
        
        return ans;
    }
}