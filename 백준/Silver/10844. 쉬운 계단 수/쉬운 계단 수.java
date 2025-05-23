import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] d = new int[101][10];
        for (int i = 1; i < 10; i++)
            d[1][i] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][1];
            d[i][9] = d[i - 1][8];
            for (int j = 1; j <= 8; j++)
                d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
        }

        int ans = 0;
        for (int i = 0; i < 10; i++)
            ans = (ans + d[n][i]) % 1000000000;

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
