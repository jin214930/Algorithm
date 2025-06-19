import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a, b;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void go(int idx) throws IOException {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                bw.write(b[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            b[idx] = a[i];
            go(idx + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        b = new int[m];

        go(0);

        bw.flush();
        bw.close();
        br.close();
    }
}