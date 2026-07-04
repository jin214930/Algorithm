import java.util.*;
import java.io.*;

public class Main {
    static char[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        a = new char[2 * n + 1][4 * n + 1];

        for (int i = 0; i < 2 * n + 1; i++) {
            Arrays.fill(a[i], ' ');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                go(2 * i, 4 * j);
            }
        }

        for (int i = 0; i < 2 * n + 1; i++) {
            for (int j = 0; j < 4 * n + 1; j++) {
                bw.write(a[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
    }

    static void go(int y, int x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 || j == 4) a[y + i][x + j] = '*';
            }
        }
        a[y][x + 2] = '*';
        a[y + 2][x + 2] = '*';
    }
}