import java.util.*;
import java.io.*;

public class Main {
    static char[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        a = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(a[i], ' ');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) a[i][j] = '*';
                else if (i > j) a[i][j] = '*';
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