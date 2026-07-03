import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int tmp = 1;

        for (int i = 0; i <= n + m - 2; i++) {
            for (int j = 0; j < n; j++) {
                if (i - j >= 0 && i - j < m) a[j][i - j] = tmp++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(a[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}