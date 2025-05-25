import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] a;

    static int count() {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = 0; j < n - 1; j++) {
                if (a[i][j] != a[i][j + 1])
                    tmp = 0;
                tmp++;
                ret = Math.max(ret, tmp);
            }
        }

        for (int j = 0; j < n; j++) {
            int tmp = 1;
            for (int i = 0; i < n - 1; i++) {
                if (a[i][j] != a[i + 1][j])
                    tmp = 0;
                tmp++;
                ret = Math.max(ret, tmp);
            }
        }

        return ret;
    }

    static void swap(int y1, int x1, int y2, int x2) {
        char tmp = a[y1][x1];
        a[y1][x1] = a[y2][x2];
        a[y2][x2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        a = new char[n][n];
        for (int i = 0; i < n; i++)
            a[i] = br.readLine().toCharArray();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[i][j] != a[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    ans = Math.max(ans, count());
                    swap(i, j, i, j + 1);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (a[i][j] != a[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    ans = Math.max(ans, count());
                    swap(i, j, i + 1, j);
                }
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
