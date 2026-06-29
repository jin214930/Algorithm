import java.util.*;
import java.io.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] d = new int[m + 1][n][n];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) Arrays.fill(d[i][j], Integer.MAX_VALUE);
        }

        for (int j = 0; j < n; j++) Arrays.fill(d[1][j], 0);

        for (int i = 2; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (d[i - 1][j][k] == Integer.MAX_VALUE) continue;
                    for (int l = 0; l < 4; l++) {
                        int ny = j + dy[l];
                        int nx = k + dx[l];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                        if (a[ny][nx] <= a[j][k]) continue;
                        int maxDiff = Math.max(d[i - 1][j][k], a[ny][nx] - a[j][k]);
                        d[i][ny][nx] = Math.min(d[i][ny][nx], maxDiff);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, d[m][i][j]);
            }
        }

        bw.write((ans == Integer.MAX_VALUE ? -1 : ans) + "");
        bw.flush();
    }
}