import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] visited = new int[2001][2001];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 1000;
            int y1 = Integer.parseInt(st.nextToken()) + 1000;
            int x2 = Integer.parseInt(st.nextToken()) + 1000;
            int y2 = Integer.parseInt(st.nextToken()) + 1000;
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    visited[j][k] = 1;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) + 1000;
        int y1 = Integer.parseInt(st.nextToken()) + 1000;
        int x2 = Integer.parseInt(st.nextToken()) + 1000;
        int y2 = Integer.parseInt(st.nextToken()) + 1000;
        for (int j = x1; j < x2; j++) {
            for (int k = y1; k < y2; k++) {
                visited[j][k] = 2;
            }
        }

        int ans = 0;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (visited[i][j] == 1) ans++;
            }
        }
        bw.write(ans + "\n");

        bw.flush();
    }
}