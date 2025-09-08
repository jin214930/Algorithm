import java.io.*;
import java.util.*;

public class Main {
    static char[][] a;

    static String go(int y, int x, int s) {
        if (s == 1) {
            if (a[y][x] == '0')
                return "0";
            else
                return "1";
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (a[y][x] != a[y + i][x + j]) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(go(y, x, s / 2));
                    sb.append(go(y, x + s / 2, s / 2));
                    sb.append(go(y + s / 2, x, s / 2));
                    sb.append(go(y + s / 2, x + s / 2, s / 2));
                    sb.append(")");
                    return sb.toString();
                }
            }
        }

        if (a[y][x] == '0')
            return "0";
        else
            return "1";
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
    }
}
