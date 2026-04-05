import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] ans = new int[numbers.length];
        for (int i = 0; i < ans.length; i++)
            ans[i] = -1;
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < numbers.length; i++) {
            while(!st.empty() && numbers[st.peek()] < numbers[i]) 
                ans[st.pop()] = numbers[i];
            st.push(i);
        }
        
        return ans;
    }
}