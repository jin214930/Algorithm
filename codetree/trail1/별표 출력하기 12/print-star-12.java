import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(a[i], ' ');
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) a[0][i] = '*';
            else {
                for (int j = 0; j <= i; j++) {
                    a[j][i] = '*';
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