import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    a[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] d = new int[n][3];
            d[0][0] = a[0][0];
            d[0][1] = a[1][0];

            for (int i = 1; i < n; i++) {
                d[i][0] = Math.max(d[i - 1][1], d[i - 1][2]) + a[0][i];
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[1][i];
                d[i][2] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
            }

            bw.write(Math.max(Math.max(d[n - 1][0], d[n - 1][1]), d[n - 1][2]) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
