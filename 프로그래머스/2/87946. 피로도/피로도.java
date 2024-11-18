class Solution {
    int ans = 0;
    boolean[] visited;
    
    void go(int cnt, int k, int[][] a) {
        ans = Math.max(ans, cnt);
        for (int i = 0; i < a.length; i++) {
            if (!visited[i] && a[i][0] <= k) {
                visited[i] = true;
                go(cnt + 1,k - a[i][1], a);
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