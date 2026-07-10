import java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int[][] a;
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (j + 2 < n) list.add(new Point(i, j));
            }
        }

        int ans = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Point p1 = list.get(i);
                Point p2 = list.get(j);
                if (p1.y == p2.y && Math.abs(p1.x - p2.x) <= 2) continue;
                int sum = 0;
                for (int k = 0; k < 3; k++) sum += a[p1.y][p1.x + k] + a[p2.y][p2.x + k];
                ans = Math.max(ans, sum);
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}