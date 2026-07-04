import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n];
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = tmp++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    a[i][j] = tmp++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(a[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}