import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] a = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = board[i].charAt(j);
            }
        }
        
        while(true) {
            boolean flag = true;
            boolean[][] check = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (a[i][j] != ' ' && a[i][j] == a[i][j + 1] && a[i][j] == a[i + 1][j] && a[i][j] == a[i + 1][ j + 1]) {
                        flag = false;
                        check[i][j] = check[i + 1][j] = check[i][j + 1] = check[i + 1][j + 1] = true;
                    }
                }
            }
            
            if (flag) break;
            
            char[][] tmp = new char[m][n];
            for (int i = 0; i < m; i++) 
                Arrays.fill(tmp[i], ' ');
            
            for (int i = 0; i < n; i++) {
                int idx = m - 1;
                for (int j = m - 1; j >= 0; j--) {
                    if (check[j][i] || a[j][i] == ' ') continue;
                    tmp[idx][i] = a[j][i];
                    idx--;
                }
            }
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = tmp[i][j];
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == ' ') ans++;
            }
        }
        
        return ans;
    }
}