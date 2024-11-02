class Solution {
    static boolean[] visited;
    static int[] cnt;
    int dfs(int x, int[][] a) {
        visited[x] = true;
        int tmp = 1;
        for(int[] i : a) {
            if(i[0] != x)
                continue;
            if(visited[i[1]])
                continue;
            cnt[i[1]]++;
            tmp += dfs(i[1] ,a);
        }
        return tmp;
    }
    public int solution(int n, int[][] results) {
        cnt = new int[n + 1];
        for(int i = 1; i <=n;i++) {
            visited = new boolean[n + 1];
            cnt[i] += dfs(i, results);
        }
        int ans = 0;
        for(int i = 1; i <=n;i++) {
            if(n == cnt[i])
                ans++;
        }
        return ans;
    }
}