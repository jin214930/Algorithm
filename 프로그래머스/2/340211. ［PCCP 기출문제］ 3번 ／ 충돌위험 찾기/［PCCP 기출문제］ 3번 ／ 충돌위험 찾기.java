import java.util.*;

class Solution {    
    public int solution(int[][] points, int[][] routes) {
        int n = routes.length;
        
        List<Integer>[] path = new ArrayList[n];
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
            
            int r = points[routes[i][0] - 1][0];
            int c = points[routes[i][0] - 1][1];
            path[i].add(r * 1000 + c);
            
            for (int j = 1; j < routes[i].length; j++) {
                int nr = points[routes[i][j] - 1][0];
                int nc = points[routes[i][j] - 1][1];
                
                while (r != nr || c != nc) {
                    if (r != nr) {
                        if (r < nr) r++;
                        else r--;
                    } else {
                        if (c < nc) c++;
                        else c--;
                    }
                    
                    path[i].add(r * 1000 + c);
                }
            }
            
            max = Math.max(max, path[i].size());
        }
        
        int ans = 0;
        int[][] map = new int[101][101];
        
        for (int t = 0; t < max; t++) {
            for (int i = 0; i < n; i++) {
                if (t < path[i].size()) {
                    int pos = path[i].get(t);
                    int r = pos / 1000;
                    int c = pos % 1000;
                    
                    map[r][c]++;
                    
                    if (map[r][c] == 2)
                        ans++;
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (t < path[i].size()) {
                    int pos = path[i].get(t);
                    int r = pos / 1000;
                    int c = pos % 1000;
                    map[r][c] = 0;
                }
            }
        }
        
        return ans;
    }

}