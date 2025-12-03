import java.io.*;
import java.util.*;

public class Main {
    static int[][] a;
    static int[] ans = new int[3];

    static void go(int y, int x, int n) {
        int tmp = a[y][x];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[y][x] != a[y + i][x + j]) {
                    go(y, x, n / 3);
                    go(y + n / 3, x, n / 3);
                    go(y + 2 * n / 3, x, n / 3);
                    go(y, x + n / 3, n / 3);
                    go(y + n / 3, x + n / 3, n / 3);
                    go(y + 2 * n / 3, x + n / 3, n / 3);
                    go(y, x + 2 * n / 3, n / 3);
                    go(y + n / 3, x + 2 * n / 3, n / 3);
                    go(y + 2 * n / 3, x + 2 * n / 3, n / 3);
                    return;
                }
            }
        }
        ans[tmp + 1]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        go(0, 0, n);

        for (int i : ans)
            bw.write(i + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}