import java.io.*;
import java.util.*;

public class Main {
    static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] a;
    static int[] ops = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        go(1, a[0]);

        bw.write(min + " " + max);
        bw.flush();
    }

    static void go(int depth, int sum) {
        if (depth == n) {
            min = Math.min(sum, min);
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (ops[i] == 0) continue;
            ops[i]--;
            if (i == 0) {
                go(depth + 1, sum + a[depth]);
            } else if (i == 1) {
                go(depth + 1, sum - a[depth]);
            } else {
                go(depth + 1, sum * a[depth]);
            }
            ops[i]++;
        }
    }
}
