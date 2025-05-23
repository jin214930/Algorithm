import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            p[i] = Integer.parseInt(st.nextToken());
        int[] d = new int[1001];
        d[1] = p[1];

        for (int i = 2; i <= n; i++) {
            d[i] = p[i];
            for (int j = 1; j < i; j++)
                d[i] = Math.max(d[i], d[i - j] + p[j]);
        }

        bw.write(d[n] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
