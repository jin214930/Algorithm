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

        boolean[] p = new boolean[1000001];
        p[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (!p[i]) {
                for (int j = i * 2; j <= 1000000; j += i)
                    p[j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = a; i <= b; i++) {
            if (!p[i])
                bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
