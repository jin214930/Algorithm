import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int[][] d = new int[100001][4];
        d[1][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            d[i][1] = (d[i - 1][2] + d[i - 1][3]) % 1000000009;
            d[i][2] = (d[i - 2][1] + d[i - 2][3]) % 1000000009;
            d[i][3] = (d[i - 3][1] + d[i - 3][2]) % 1000000009;
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(((d[n][1] + d[n][2]) % 1000000009 + d[n][3]) % 1000000009 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}