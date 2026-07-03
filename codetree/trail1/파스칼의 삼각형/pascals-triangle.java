import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n];
        a[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) a[i][j] = 1;
                else if (j == i) a[i][j] = 1;
                else a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                bw.write(a[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}