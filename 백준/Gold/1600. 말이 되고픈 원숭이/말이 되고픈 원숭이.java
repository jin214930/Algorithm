import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x, h;

        Node(int y, int x, int h) {
            this.y = y;
            this.x = x;
            this.h = h;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] dyH = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dxH = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Node> q = new LinkedList<>();
        int[][][] visited = new int[h][w][k + 1];
        q.add(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        int ans = -1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.y == h - 1 && node.x == w - 1) {
                ans = visited[node.y][node.x][node.h] - 1;
                break;
            }

            if (node.h < k) {
                for (int i = 0; i < 8; i++) {
                    int ny = node.y + dyH[i];
                    int nx = node.x + dxH[i];
                    if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                    if (visited[ny][nx][node.h + 1] != 0 || a[ny][nx] == 1) continue;
                    q.add(new Node(ny, nx, node.h + 1));
                    visited[ny][nx][node.h + 1] = visited[node.y][node.x][node.h] + 1;
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                if (visited[ny][nx][node.h] != 0 || a[ny][nx] == 1) continue;
                q.add(new Node(ny, nx, node.h));
                visited[ny][nx][node.h] = visited[node.y][node.x][node.h] + 1;
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}