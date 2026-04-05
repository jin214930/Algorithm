class Solution {
    int n, m;
    
    int[][] rotate(int[][] key) {
        int[][] tmp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = key[m - j - 1][i];
            }
        }
        return tmp;
    }
    
    boolean check(int y, int x, int[][] key, int[][] lock) {
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++)
                tmp[i][j] = lock[i][j];
        }
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if (i + y >= n || j + x >= n || i + y < 0 || j + x < 0)
                    continue;
                if (lock[i + y][j + x] == 1 && key[i][j] == 1)
                    return false;
                if (lock[i + y][j + x] == 0 && key[i][j] == 1)
                    tmp[i + y][j + x] = 1;                    
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (tmp[i][j] == 0)
                    return false;   
        }
        
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;
         
        for (int i = -m; i < n; i++) {
            for (int j = -m; j < n; j++)                   
                for (int k = 0; k < 4; k++) {
                    key = rotate(key);
                    if (check(i, j, key, lock))
                        return true;
                }
        }
        
        return false;
    }
}