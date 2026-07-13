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
        d[0][0] = a[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) d[i][j] = Math.max(a[i][j], d[i][j - 1]);
                if (j == 0) d[i][j] = Math.max(a[i][j], d[i - 1][j]);
                if (i != 0 && j != 0) d[i][j] = Math.max(a[i][j], Math.min(d[i - 1][j], d[i][j - 1]));
            }
        }

        bw.write(d[n - 1][n - 1] + "\n");
        bw.flush();
    }
}
