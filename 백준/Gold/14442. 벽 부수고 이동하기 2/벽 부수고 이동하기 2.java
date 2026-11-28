import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x, b;

        public Node(int y, int x, int b) {
            this.y = y;
            this.x = x;
            this.b = b;
        }
    }

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine().toCharArray();
        }

        Queue<Node> q = new LinkedList<>();
        int[][][] visited = new int[n][m][k + 1];
        q.offer(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == n - 1 && cur.x == m - 1) {
                bw.write(visited[cur.y][cur.x][cur.b] + "");
                bw.flush();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (a[ny][nx] == '0') {
                    if (visited[ny][nx][cur.b] != 0)
                        continue;
                    q.offer(new Node(ny, nx, cur.b));
                    visited[ny][nx][cur.b] = visited[cur.y][cur.x][cur.b] + 1;
                } else {
                    if (cur.b == k || visited[ny][nx][cur.b + 1] != 0)
                        continue;
                    q.offer(new Node(ny, nx, cur.b + 1));
                    visited[ny][nx][cur.b + 1] = visited[cur.y][cur.x][cur.b] + 1;
                }
            }
        }

        bw.write("-1");

        bw.flush();
    }
}
