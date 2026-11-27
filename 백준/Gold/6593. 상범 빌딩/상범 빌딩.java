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

    static int[] dz = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dx = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (h == 0 && n == 0 && m == 0)
                break;

            char[][][] a = new char[h][n][m];
            Queue<Node> q = new LinkedList<>();
            int[][][] visited = new int[h][n][m];

            int ez = -1, ey = -1, ex = -1;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < m; k++) {
                        a[i][j][k] = s.charAt(k);
                        if (a[i][j][k] == 'S') {
                            q.offer(new Node(i, j, k));
                            visited[i][j][k] = 1;
                        } else if (a[i][j][k] == 'E') {
                            ez = i;
                            ey = j;
                            ex = k;
                        }
                    }
                }
                br.readLine();
            }

            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.z == ez && cur.y == ey && cur.x == ex)
                    break;
                for (int i = 0; i < 6; i++) {
                    int nz = cur.z + dz[i];
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m)
                        continue;
                    if (a[nz][ny][nx] == '#' || visited[nz][ny][nx] != 0)
                        continue;
                    q.offer(new Node(nz, ny, nx));
                    visited[nz][ny][nx] = visited[cur.z][cur.y][cur.x] + 1;
                }
            }

            if (visited[ez][ey][ex] == 0) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + (visited[ez][ey][ex] - 1) + " minute(s).\n");
            }
        }

        bw.flush();
    }
}
