import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a, b;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void go(int idx, int start) throws IOException {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                bw.write(b[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = start; i < n; i++) {
            b[idx] = a[i];
            go(idx + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        b = new int[m];

        go(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}