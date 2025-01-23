import java.io.*;
import java.util.*;

public class Main {
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

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            for (int i = 3; i <= n; i++) {
                if (!p[i] && !p[n - i]) {
                    bw.write(n + " = " + i + " + " + (n - i) + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

