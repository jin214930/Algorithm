import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] d = new long[1001];
        d[0] = 1;
        d[1] = 2;
        for (int i = 2; i <= n; i++) {
            d[i] = (d[i - 1] * 2 + d[i - 2] * 3) % 1000000007;
            for (int j = i - 3; j >= 0; j--) {
                d[i] = (d[i] + d[j] * 2) % 1000000007;
            }
        }

        bw.write(d[n] + "");
        bw.flush();
    }
}