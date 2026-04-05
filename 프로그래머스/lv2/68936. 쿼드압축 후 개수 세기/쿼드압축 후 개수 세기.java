class Solution {
    int[] ans = new int[2];
    
    void go(int y, int x, int n, int[][] arr) {        
        int tmp = arr[y][x];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp != arr[y + i][x + j]) {
                    go(y, x, n / 2, arr);
                    go(y + n / 2, x, n/2, arr);
                    go(y, x + n/2, n/2, arr);
                    go(y + n/2,x+n/2, n/2,arr);
                    return;
                }
            }
        }
        ans[tmp]++;
    }
    
    public int[] solution(int[][] arr) {
        go(0, 0, arr.length, arr);
        
        return ans;
    }
}