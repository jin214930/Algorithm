import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        int[][] d = new int[n][3];
        d[0][1] = a[0];

        for (int i = 1; i < n; i++) {
            d[i][0] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
            d[i][1] = d[i - 1][0] + a[i];
            d[i][2] = d[i - 1][1] + a[i];
        }

        bw.write(Math.max(Math.max(d[n - 1][0], d[n - 1][1]), d[n - 1][2]) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
