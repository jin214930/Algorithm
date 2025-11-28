import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] a;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] != a[y][x] || visited[ny][nx]) continue;
            dfs(ny, nx);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        a = new char[n][n];
        for (int i = 0; i < n; i++)
            a[i] = br.readLine().toCharArray();

        visited = new boolean[n][n];
        int ans1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    ans1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'G')
                    a[i][j] = 'R';
            }
        }

        visited = new boolean[n][n];
        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    ans2++;
                }
            }
        }

        bw.write(ans1 + " " + ans2);

        bw.flush();
        bw.close();
        br.close();
    }
}