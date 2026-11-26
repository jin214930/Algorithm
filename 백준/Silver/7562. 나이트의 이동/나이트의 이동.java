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

    static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            int[][] visited = new int[n][n];
            q.offer(new Node(sy, sx));
            visited[sy][sx] = 1;

            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.y == ey && cur.x == ex)
                    break;
                for (int i = 0; i < 8; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] != 0)
                        continue;
                    q.offer(new Node(ny, nx));
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                }
            }

            bw.write(visited[ey][ex] - 1 + "\n");
        }

        bw.flush();
    }
}
