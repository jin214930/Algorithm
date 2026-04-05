/*
1. 방향 벡터 정의
2. 2차원 배열 정의
3. 채우기
4. 1차원 배열로 리턴
*/

class Solution {
    int[] dy = {1, 0, -1};
    int[] dx = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] map = new int[n][];
        for(int i = 0; i < n; i++) {
            map[i] = new int[i + 1];
        }
        
        int y = 0, x = 0, d = 0, tmp = 1;
        int cnt = n * (n + 1) / 2;
        while(cnt-- > 0) {
            map[y][x] = tmp++;
            
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny >= n || nx > ny || map[ny][nx] != 0) {
                d = (d + 1) % 3;
                ny = y + dy[d];
                nx = x + dx[d];
            }
            
            y = ny;
            x = nx;
        }
        
        int[] ans = new int[n * (n + 1) / 2];
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                ans[idx++] = map[i][j];
            }
        }
        
        return ans;        
    }
}