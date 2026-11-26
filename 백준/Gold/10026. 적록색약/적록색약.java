import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] a;
    static boolean[][] visited;

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][n];
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs1(i, j);
                    cnt1++;
                }
            }
        }

        visited = new boolean[n][n];
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs2(i, j);
                    cnt2++;
                }
            }
        }

        bw.write(cnt1 + " " + cnt2);

        bw.flush();
    }

    static void dfs1(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                continue;
            if (a[ny][nx] != a[y][x] || visited[ny][nx])
                continue;
            dfs1(ny, nx);
        }
    }

    static void dfs2(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx])
                continue;
            if (a[ny][nx] != a[y][x] && (a[ny][nx] == 'B' || a[y][x] == 'B'))
                continue;
            dfs2(ny, nx);
        }
    }
}
