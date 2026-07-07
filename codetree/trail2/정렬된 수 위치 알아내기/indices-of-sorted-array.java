import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, idx;

        public Point(int x, int idx) {
            this.x = x;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            points[i] = new Point(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(points, (p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.idx - p2.idx;
            }
            return p1.x - p2.x;
        });

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[points[i].idx] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
    }
}