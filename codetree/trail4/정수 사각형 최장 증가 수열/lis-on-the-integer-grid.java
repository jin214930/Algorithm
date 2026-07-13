import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] a, d;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    static int dfs(int y, int x) {
        if (d[y][x] != 0)
            return d[y][x];
        d[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                continue;
            if (a[y][x] < a[ny][nx])
                d[y][x] = Math.max(d[y][x], dfs(ny, nx) + 1);
        }
        return d[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                ans = Math.max(ans, dfs(i, j));
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}