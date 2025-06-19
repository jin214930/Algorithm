import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void go(int idx) throws IOException {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                bw.write(a[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 1; i <= n; i++) {
            a[idx] = i;
            go(idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[m];

        go(0);

        bw.flush();
        bw.close();
        br.close();
    }
}