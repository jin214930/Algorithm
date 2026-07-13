import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] d = new int[n][n];
        d[0][n - 1] = a[0][n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == 0 && j == n - 1) continue;
                if (i == 0) d[i][j] = d[i][j + 1] + a[i][j];
                if (j == n - 1) d[i][j] = d[i - 1][j] + a[i][j];
                if (i != 0 && j != n - 1) d[i][j] = Math.min(d[i - 1][j], d[i][j + 1]) + a[i][j];
            }
        }

        bw.write(d[n - 1][0] + "\n");
        bw.flush();
    }
}
