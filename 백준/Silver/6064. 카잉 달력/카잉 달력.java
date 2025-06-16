import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            x--;
            y--;

            int ans = 0;
            boolean flag = true;
            for (int i = x; i < m * n; i += m) {
                if (i % n == y) {
                    bw.write(i + 1 + "\n");
                    flag = false;
                    break;
                }
            }

            if (flag)
                bw.write("-1\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}