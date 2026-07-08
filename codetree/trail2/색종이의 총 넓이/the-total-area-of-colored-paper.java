import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] visited = new boolean[201][201];
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 100;
            int y = Integer.parseInt(st.nextToken()) + 100;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    visited[y + i][x + j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (visited[i][j]) ans++;
            }
        }
        bw.write(ans + "\n");

        bw.flush();
    }
}