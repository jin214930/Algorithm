class Solution {
    public int solution(int n, int w, int num) {
        int[][] a = new int[100][w];
        int y = 0;
        int x = 0;
        int d = 1;
        int numY = -1, numX = -1;
        for (int i = 1; i <= n; i++) {
            a[y][x] = i;
            if (i == num) {
                numY = y;
                numX = x;
            }
            if ((x == 0 && d == -1) || (x == w - 1 && d == 1)) {
                d *= -1;
                y++;
                continue;
            }
            
            x += d; 
        }
        
        int ans = 0;
        while (true) {
            if (a[numY][numX] == 0)
                break;
            ans++;
            numY++;
        }
        
        return ans;
    }
}