import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    int tmp = board[i][move - 1];
                    board[i][move - 1] = 0;
                    if (!st.empty() && st.peek() == tmp) {
                        st.pop();
                        ans += 2;
                    } else
                        st.add(tmp);
                    break;
                }
            }
        }
        
        return ans;
    }
}