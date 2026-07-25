class Solution {
    static char[][] a;
    
    public int solution(int m, int n, String[] board) {
        a = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = board[i].charAt(j);
            }
        }
        
        int ans = 0;
        while (true) {            
            boolean isBomb = false;
            boolean[][] check = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = a[i][j];
                    if (c == '\0') continue;
                    boolean isSame = true;
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                            if (c != a[i + k][j + l]) isSame = false;
                        }
                    }
                    if (isSame) {
                        for (int k = 0; k < 2; k++) {
                            for (int l = 0; l < 2; l++) {
                                check[i + k][j + l] = true;
                            }
                        }
                        isBomb = true;
                    }
                }
            }
            
            if (!isBomb) break;
            
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        a[i][j] = '\0';
                        cnt++;
                    }
                }
            }
            ans += cnt;
            
            char[][] newA = new char[m][n];
            for (int i = 0; i < n; i++) {
                int idx = m - 1;
                for (int j = m - 1; j >= 0; j--) {
                    if (a[j][i] != '\0') newA[idx--][i] = a[j][i];
                }
            }
            a = newA;
        }
        
        return ans;
    }
}