class Solution {
    int ans;
    boolean[] visited;
    
    void go(int cnt, int k, int[][] dungeons) {
        ans = Math.max(ans, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                go(cnt + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        go(0, k, dungeons);
        
        return ans;
    }
}