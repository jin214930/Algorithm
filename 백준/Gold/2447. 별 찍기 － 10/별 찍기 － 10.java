import java.io.*;
import java.util.*;

public class Main {
    static char[][] a;

    static void go(int y, int x, int n) {
        if (n == 1) {
            a[y][x] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                go(y + n / 3 * i, x + n / 3 * j, n / 3);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        a = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = ' ';
        }


        go(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                bw.write(a[i][j] + "");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}