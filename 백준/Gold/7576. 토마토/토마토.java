import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 1) {
                    q.offer(new Node(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (a[ny][nx] != 0 || visited[ny][nx] != 0)
                    continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != -1 && visited[i][j] == 0) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
                ans = Math.max(ans, visited[i][j]);
            }
        }

        bw.write((ans - 1) + "");
        bw.flush();
    }
}
