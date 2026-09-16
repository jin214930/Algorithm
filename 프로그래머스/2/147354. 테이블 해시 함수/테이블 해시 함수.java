import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (d1, d2) -> {
            if (d1[col - 1] == d2[col - 1]) {
                return d2[0] - d1[0];
            }
            
            return d1[col - 1] - d2[col - 1];
        });
        
        int ans = -1;
        for (int i = row_begin - 1; i < row_end; i++) {
            int s = 0;
            for (int j = 0; j < data[0].length; j++) {
                s += data[i][j] % (i + 1);
            }
            if (ans == -1) ans = s;
            else ans ^= s;
        }
        
        return ans;
    }
}