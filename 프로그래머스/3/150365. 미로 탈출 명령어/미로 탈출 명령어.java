import java.util.*;

class Solution {
    String ans = "impossible";
    int[] dy = { 1, 0, 0, -1 };
    int[] dx = { 0, -1, 1, 0 };
    char[] d = { 'd', 'l', 'r', 'u' };
    boolean flag = false;
    
    void dfs(int y, int x, String s, int n, int m, int r, int c, int k) {
        if(!ans.equals("impossible"))
            return;
        
        int dis = Math.abs(r - y) + Math.abs(c - x);
        if(dis > k - s.length() || (k - s.length() - dis) % 2 == 1)
            return;
        
        if(s.length() == k) {
            if(r == y && c == x) {
            ans = s;
            flag = true;
            }
            return;
        }

        for(int i = 0; i < 4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny <= 0 || nx <= 0 || ny > n || nx > m)
                continue;
            dfs(ny, nx, s + d[i], n, m, r, c, k);
        }
    }
    
    public String solution(int n, int m, int y, int x, int r, int c, int k) {
        int d = Math.abs(r - y) + Math.abs(c - x);
        if(d > k || (k - d) % 2 == 1)
            return ans;
        dfs(y, x, "", n, m, r, c, k);
        
        return ans;
    }
}