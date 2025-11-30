import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] a;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 0 || visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        while (true) {
            int[][] tmp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != 0) {
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            if (ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] != 0) continue;
                            tmp[i][j]++;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    a[i][j] = Math.max(0, a[i][j] - tmp[i][j]);
            }
            ans++;

            visited = new boolean[n][m];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt >= 2) {
                bw.write(ans + "");

                bw.flush();
                bw.close();
                br.close();
                return;
            }

            if (cnt == 0)
                break;
        }

        bw.write("0");

        bw.flush();
        bw.close();
        br.close();
    }
}