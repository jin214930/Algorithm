import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) != n / 2) continue;

            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((i & (1 << j)) != 0 && (i & (1 << k)) != 0) {
                        sum1 += p[j][k];
                    } else if ((i & (1 << j)) == 0 && (i & (1 << k)) == 0) {
                        sum2 += p[j][k];
                    }
                }
            }

            ans = Math.min(ans, Math.abs(sum1 - sum2));
        }

        bw.write(ans + "");
        bw.flush();
    }
}
