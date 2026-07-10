import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x;
        int y;

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
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int x = points[0].x;
            int y = points[0].y;
            int sum = 0;
            for (int j = 1; j < n; j++) {
                if (i == j) continue;
                int d = Math.abs(x - points[j].x) + Math.abs(y - points[j].y);
                sum += d;
                x = points[j].x;
                y = points[j].y;
            }
            ans = Math.min(ans, sum);
        }
        
        bw.write(ans + "");
        bw.flush();
    }
}