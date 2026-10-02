import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r, cnt, idx;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            visited = new int[n][n];
            idx = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cnt = 0;
                    if (visited[i][j] == 0) {
                        idx++;
                        int sum = dfs(i, j);
                        map.put(idx, sum / cnt);
                    }
                }
            }

            if (idx == n * n) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = map.get(visited[i][j]);
                }
            }

            ans++;
        }

        bw.write(ans + "");
        bw.flush();
    }

    static int dfs(int y, int x) {
        visited[y][x] = idx;
        int ret = a[y][x];
        cnt++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] != 0) continue;
            int diff = Math.abs(a[y][x] - a[ny][nx]);
            if (diff >= l && diff <= r) {
                ret += dfs(ny, nx);
            }  
        }

        return ret;
    }
}