import java.util.*;

class Solution {
    public int solution(int[] order) {
        int idx = 0;
        int now = 1;
        
        Stack<Integer> st = new Stack<>();
        
        while (idx < order.length) {
            while(!st.isEmpty() && order[idx] == st.peek()) {
                st.pop();
                idx++;
            }
            
            st.push(now);
            now++;
            
            if (now > order.length + 1) {
                break;
            }
        }
        
        return idx;
    }
}