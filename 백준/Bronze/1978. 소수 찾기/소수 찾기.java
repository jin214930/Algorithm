import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] p = new boolean[1001];
        p[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (!p[i]) {
                for (int j = i * 2; j <= 1000; j += i)
                    p[j] = true;
            }
        }

        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (!p[x])
                ans++;
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
