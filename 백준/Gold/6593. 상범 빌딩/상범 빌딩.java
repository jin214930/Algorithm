import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int z, y, x;

        Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0)
                break;

            char[][][] a = new char[l][r][c];
            Queue<Node> q = new LinkedList<>();
            int[][][] visited = new int[l][r][c];
            int ez = -1, ey = -1, ex = -1;
            for (int i = 0; i < l; i++) {

                for (int j = 0; j <= r; j++) {
                    if (j == r) {
                        br.readLine();
                        continue;
                    }

                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        a[i][j][k] = s.charAt(k);
                        if (a[i][j][k] == 'S') {
                            q.add(new Node(i, j, k));
                            visited[i][j][k] = 1;
                        } else if (a[i][j][k] == 'E') {
                            ez = i;
                            ey = j;
                            ex = k;
                        }
                    }
                }
            }

            while (!q.isEmpty()) {
                Node node = q.poll();
                if (node.z == ez && node.y == ey && node.x == ex)
                    break;

                for (int d = 0; d < 6; d++) {
                    int nz = node.z + dz[d];
                    int ny = node.y + dy[d];
                    int nx = node.x + dx[d];
                    if (nz < 0 || ny < 0 || nx < 0 || nz >= l || ny >= r || nx >= c || a[nz][ny][nx] == '#' || visited[nz][ny][nx] != 0)
                        continue;
                    q.add(new Node(nz, ny, nx));
                    visited[nz][ny][nx] = visited[node.z][node.y][node.x] + 1;
                }
            }

            if (visited[ez][ey][ex] == 0)
                bw.write("Trapped!\n");
            else
                bw.write("Escaped in " + (visited[ez][ey][ex] - 1) + " minute(s).\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}