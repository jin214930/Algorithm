class Solution {
    boolean[] visited;
    int ans = 0;
    
    void dfs(int x, int[][] computers) {
        visited[x] = true;
        for(int i = 0; i < computers[x].length; i++) {
            if(computers[x][i] == 0 || visited[i]) continue;
            dfs(i, computers);
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                ans++;
            }
        }
        
        return ans;
    }
}