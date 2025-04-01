import java.io.*;
import java.util.*;

public class Main {
    static char[][] a = new char[2500][2500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        go(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != '*')
                    bw.write(' ');
                else
                    bw.write(a[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void go(int y, int x, int n) {
        if (n == 1) {
            a[y][x] = '*';
            return;
        }

        go(y, x, n / 3);
        go(y, x + n / 3, n / 3);
        go(y, x + 2 * n / 3, n / 3);
        go(y + n / 3, x, n / 3);
        go(y + n / 3, x + 2 * n / 3, n / 3);
        go(y + 2 * n / 3, x, n / 3);
        go(y + 2 * n / 3, x + n / 3, n / 3);
        go(y + 2 * n / 3, x + 2 * n / 3, n / 3);
    }
}