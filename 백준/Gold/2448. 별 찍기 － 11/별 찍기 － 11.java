import java.io.*;
import java.util.*;

public class Main {
    static char[][] a;

    static void go(int n, int y, int x) {
        if (n == 3) {
            a[y][x] = '*';
            a[y + 1][x - 1] = a[y + 1][x + 1] = '*';
            a[y + 2][x - 2] = a[y + 2][x - 1] = a[y + 2][x] = a[y + 2][x + 1] = a[y + 2][x + 2] = '*';
            return;
        }

        go(n / 2, y, x);
        go(n / 2, y + n / 2, x - n / 2);
        go(n / 2, y + n / 2, x + n / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        a = new char[n][2 * n];
        for (int i = 0; i < n; i++)
            Arrays.fill(a[i], ' ');


        go(n, 0, n - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++)
                bw.write(a[i][j]);
            bw.write('\n');
        }
        bw.flush();
    }
}