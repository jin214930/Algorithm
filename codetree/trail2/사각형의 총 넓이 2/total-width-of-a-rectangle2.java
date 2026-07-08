import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[201][201];
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                if (visited[i][j]) ans++;
            }
        }
        bw.write(ans + "");

        bw.flush();
    }
}