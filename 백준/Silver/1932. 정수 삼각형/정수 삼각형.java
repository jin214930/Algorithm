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

            for (int j = 0; j <= i; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++)
            d[n - 1][i] = a[n - 1][i];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++)
                d[i][j] = Math.max(d[i + 1][j], d[i + 1][j + 1]) + a[i][j];
        }

        bw.write(d[0][0] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
