class Solution {
    int[] ans = new int[2];
    public int[] solution(int[][] arr) {
        go(0, 0, arr.length, arr);
        
        return ans;
    }
    
    void go(int y, int x, int n, int[][] arr) {
        int tmp = arr[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (tmp != arr[i][j]) {
                    go(y, x, n / 2, arr);
                    go(y + n / 2, x, n / 2, arr);
                    go(y, x + n / 2, n / 2, arr);
                    go(y + n / 2, x + n / 2, n / 2, arr);
                    return;
                }
            }
        }
        ans[tmp]++;
    }
}