import java.util.*;
import java.io.*;

public class Main {
    static class Work {
        int t, p;

        Work(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    static int n;
    static Work[] works;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        works = new Work[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        for (int i = 1; i < (1 << n); i++) {
            if (!check(i)) continue;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    sum += works[j].p;
                }
            }
            ans = Math.max(ans, sum);
        }

        bw.write(ans + "");
        bw.flush();
    }

    static boolean check(int x) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if ((x & (1 << i)) != 0) {
                for (int j = 0; j < works[i].t; j++) {
                    if (i + j >= n || visited[i + j]) return false;
                    visited[i + j] = true;
                }
            }
        }
        return true;
    }
}