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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3;j++) {
                if(i == 1 && j == 1)
                    continue;
                go(y + i * n / 3, x + j * n / 3, n / 3);
            }
        }
    }
}