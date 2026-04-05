import java.util.*;

class Solution {
    public int solution(int[] order) {
        int idx = 0;
        Stack<Integer> st = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            st.push(i);
            
            while (!st.isEmpty() && st.peek() == order[idx]) {
                st.pop();
                idx++;
            }
        }
        
        return idx;
    }
}