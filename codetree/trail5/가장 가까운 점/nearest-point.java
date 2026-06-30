import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.x + p1.y == p2.x + p2.y) {
                if (p1.x == p2.x) return p1.y - p2.y;
                return p1.x - p2.x;
            }
            return (p1.x + p1.y) - (p2.x + p2.y);
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Point(x, y));
        }

        while (m-- > 0) {
            Point p = pq.poll();
            pq.add(new Point(p.x + 2, p.y + 2));
        }

        Point p = pq.poll();
        bw.write(p.x + " " + p.y);

        bw.flush();
    }
}