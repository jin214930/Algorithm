import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] d = new int[100001][3];
        d[1][0] = 1;
        d[1][1] = 1;
        d[1][2] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {
            d[i][0] = (d[i - 1][1] + d[i - 1][2]) % 9901;
            d[i][1] = (d[i - 1][0] + d[i - 1][2]) % 9901;
            d[i][2] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % 9901;
        }

        bw.write((d[n][0] + d[n][1] + d[n][2]) % 9901 + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
