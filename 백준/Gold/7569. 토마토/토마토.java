import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int z, y, x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int[] dz = { 1, -1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] a = new int[h][n][m];
        int[][][] visited = new int[h][n][m];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    a[i][j][k] = Integer.parseInt(st.nextToken());
                    if (a[i][j][k] == 1) {
                        q.offer(new Node(i, j, k));
                        visited[i][j][k] = 1;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m)
                    continue;
                if (visited[nz][ny][nx] != 0 || a[nz][ny][nx] == -1)
                    continue;
                q.offer(new Node(nz, ny, nx));
                visited[nz][ny][nx] = visited[cur.z][cur.y][cur.x] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (a[i][j][k] == 0 && visited[i][j][k] == 0) {
                        bw.write("-1");
                        bw.flush();
                        return;
                    }
                    ans = Math.max(ans, visited[i][j][k] - 1);
                }
            }
        }

        bw.write(ans + "");

        bw.flush();
    }
}
