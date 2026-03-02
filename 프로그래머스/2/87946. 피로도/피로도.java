class Solution {
    int ans = 0;
    boolean[] visited;
    
    void go(int k, int[][] dungeons, int cnt) {
        ans = Math.max(ans, cnt);
        for(int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (dungeons[i][0] > k) continue;
            
            visited[i] = true;
            go(k - dungeons[i][1], dungeons, cnt + 1);
            visited[i] = false;            
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        go(k, dungeons, 0);
        
        return ans;
    }
}