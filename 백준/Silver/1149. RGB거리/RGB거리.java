import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[n + 1][3];
        d[1][0] = a[1][0];
        d[1][1] = a[1][1];
        d[1][2] = a[1][2];

        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
        }

        bw.write(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]) + "");


        bw.flush();
        bw.close();
        br.close();
    }
}
