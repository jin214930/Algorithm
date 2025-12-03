import java.io.*;
import java.util.*;

public class Main {
    static char[][] a;

    static String go(int y, int x, int n) {
        StringBuilder sb = new StringBuilder();

        char tmp = a[y][x];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp != a[y + i][x + j]) {
                    sb.append("(");
                    sb.append(go(y, x, n / 2));
                    sb.append(go(y, x + n / 2, n / 2));
                    sb.append(go(y + n / 2, x, n / 2));
                    sb.append(go(y + n / 2, x + n / 2, n / 2));
                    sb.append(")");
                    return sb.toString();
                }
            }
        }

        sb.append(tmp);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        a = new char[n][n];
        for (int i = 0; i < n; i++)
            a[i] = br.readLine().toCharArray();

        bw.write(go(0, 0, n));

        bw.flush();
        bw.close();
        br.close();
    }
}