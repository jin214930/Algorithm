import java.util.*;
class Solution {
    public int solution(int n) {
        Stack<Integer> st = new Stack<>();
        while(n != 0) {
            st.push(n % 3);
            n /= 3;
        }
        int tmp = 1;
        int ans = 0;
        while(!st.isEmpty()) {
            ans += st.pop() * tmp;
            tmp *= 3;
        }
        return ans;
    }
}