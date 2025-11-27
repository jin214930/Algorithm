import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] a;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void dfs(int y, int x, int h) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] <= h || visited[ny][nx]) continue;
            dfs(ny, nx, h);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        a = new int[n][n];
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, a[i][j]);
            }
        }

        int ans = 0;
        for (int h = 0; h <= maxH; h++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}