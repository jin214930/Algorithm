import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y, idx;

        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i + 1);
        }

        Arrays.sort(points, (p1, p2) -> {
            int d1 = Math.abs(p1.x) + Math.abs(p1.y);
            int d2 = Math.abs(p2.x) + Math.abs(p2.y);

            if (d1 == d2) {
                return p1.idx - p2.idx;
            }
            return d1 - d2;
        });

        for (int i = 0; i < n; i++) {
            bw.write(points[i].idx + "\n");
        }


        bw.flush();
    }
}