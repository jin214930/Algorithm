import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        
        for (int i : ingredient) {
            st.push(i);
            if (st.size() >= 4 && st.peek() == 1) {
                if (st.elementAt(st.size() - 2) == 3 && st.elementAt(st.size() - 3) == 2 && st.elementAt(st.size() - 4) == 1) {
                    for (int j = 0; j < 4; j++)
                        st.pop();
                    ans++;
                }
            }
        }
        
        return ans;
    }
}