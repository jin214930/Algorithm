import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean flag = true;
        int[][] a = new int[n][n];
        int tmp = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (flag) {
                for (int j = n - 1; j >= 0; j--) {
                    a[j][i] = tmp++;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    a[j][i] = tmp++;
                }
            }
            
            flag = !flag;
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