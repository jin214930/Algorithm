class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dh = {0, 1, 0, -1}, dw = {1, 0, -1, 0};
        
        int ans = 0;
        for(int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            if (nh < 0 || nw < 0 || nh >= board.length || nw >= board.length)
                continue;
            if (board[h][w].equals(board[nh][nw]))
                ans++;
        }
        
        return ans;
    }
}