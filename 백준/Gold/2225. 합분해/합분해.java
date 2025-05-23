import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] d = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            d[i][1] = 1;
        for (int i = 1; i <= k; i++)
            d[0][i] = 1;


        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l <= i; l++) {
                    d[i][j] += d[l][j - 1];
                    d[i][j] %= 1000000000;
                }
            }
        }

        bw.write(d[n][k] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
