import java.util.*;
import java.io.*;

public class Main {
    static int n, m, c;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int y1 = 0; y1 < n; y1++) {
            for (int x1 = 0; x1 <= n - m; x1++) {
                for (int y2 = 0; y2 < n; y2++) {
                    for (int x2 = 0; x2 <= n - m; x2++) {
                        if (y1 == y2 && !(x1 + m - 1 < x2 || x2 + m - 1 < x1)) {
                            continue;
                        }

                        ans = Math.max(ans, getValue(y1, x1) + getValue(y2, x2));
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
    }

    static int getValue(int y, int x) {
        int ret = 0;

        for (int i = 1; i < (1 << m); i++) {
            int w = 0;
            int v = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    w += a[y][x + j];
                    v += a[y][x + j] * a[y][x + j];
                }
            }
            if (w <= c) {
                ret = Math.max(ret, v);
            }
        }

        return ret;
    }
}
