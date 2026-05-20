import java.util.*;
import java.io.*;

public class Main {
    static class Line {
        int a, b;

        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int n, m;
    static Line[] lines;
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lines = new Line[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a, b);
        }

        Arrays.sort(lines, (l1, l2) -> l1.b - l2.b);

        target = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            target[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = lines[i].a;
            int tmp = target[a];
            target[a] = target[a + 1];
            target[a + 1] = tmp;
        }

        int ans = m;
        for (int i = 0; i < 1 << m; i++) {
            if (check(i)) {
                ans = Math.min(ans, Integer.bitCount(i));
            }
        }

        bw.write(ans + "");
        bw.flush();
    }

    static boolean check(int x) {
        int[] pos = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pos[i] = i;
        }

        for (int i = 0; i < m; i++) {
            if ((x & 1 << i) != 0) {
                int a = lines[i].a;
                int tmp = pos[a];
                pos[a] = pos[a + 1];
                pos[a + 1] = tmp;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (pos[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
