import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[n][3];
        int ans = 1000000000;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    d[0][j] = a[0][j];
                else
                    d[0][j] = 1000000000;
            }

            for (int j = 1; j < n; j++) {
                d[j][0] = Math.min(d[j - 1][1], d[j - 1][2]) + a[j][0];
                d[j][1] = Math.min(d[j - 1][0], d[j - 1][2]) + a[j][1];
                d[j][2] = Math.min(d[j - 1][0], d[j - 1][1]) + a[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (i != j)
                    ans = Math.min(ans, d[n - 1][j]);
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
