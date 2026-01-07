import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, (p1, p2) -> {
            if (p1.x == p2.x)
                return p1.y - p2.y;
            return p1.x - p2.x;
        });

        for (Point point : points)
            bw.write(point.x + " " + point.y + "\n");


        bw.flush();
    }
}