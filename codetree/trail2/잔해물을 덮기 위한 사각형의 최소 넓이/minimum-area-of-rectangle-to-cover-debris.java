import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] visited = new int[2001][2001];

        for (int i = 1; i <= 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 1000;
            int y1 = Integer.parseInt(st.nextToken()) + 1000;
            int x2 = Integer.parseInt(st.nextToken()) + 1000;
            int y2 = Integer.parseInt(st.nextToken()) + 1000;
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    visited[k][j] = i;
                }
            }
        }

        int maxX = 0, maxY = 0, minX = 10000, minY = 10000;
        boolean flag = false;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (visited[i][j] == 1) {
                    flag = true;
                    maxY = Math.max(maxY, i);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                }
            }
        }
        if (!flag) {
            bw.write("0");
        } else {
            bw.write((maxY - minY + 1) * (maxX - minX + 1) + "");
        }
        bw.flush();
    }
}