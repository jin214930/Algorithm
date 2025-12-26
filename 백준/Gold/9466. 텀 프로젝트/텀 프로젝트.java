import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] s;
    static boolean[] visited, finished;

    static void dfs(int x) {
        visited[x] = true;

        int nx = s[x];
        if (!visited[nx])
            dfs(nx);
        else {
            if (!finished[nx]) {
                cnt++;
                for (int i = nx; i != x; i = s[i])
                    cnt++;
            }
        }

        finished[x] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            s = new int[n + 1];
            finished = new boolean[n + 1];
            visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                s[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (!finished[i])
                    dfs(i);
            }

            bw.write((n - cnt) + "\n");
        }

        bw.flush();
    }
}