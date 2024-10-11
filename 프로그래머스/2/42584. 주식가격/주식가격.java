import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < prices.length;i++) {
            while(!st.empty() && prices[st.peek()] > prices[i]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()) {
            ans[st.peek()] = prices.length - st.peek() - 1;
            st.pop();
        }
        return ans;
    }
}