class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] d = new int[m + 1][n + 1];
        d[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                boolean flag = false;
                for (int[] puddle : puddles) {
                    if (i == puddle[0] && j == puddle[1]) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    continue;                
                if (i - 1 > 0)
                    d[i][j] += d[i - 1][j];
                if (j - 1 > 0)
                    d[i][j] += d[i][j - 1];
                d[i][j] %= 1000000007;
            }
        }
        
        return d[m][n];
    }
}