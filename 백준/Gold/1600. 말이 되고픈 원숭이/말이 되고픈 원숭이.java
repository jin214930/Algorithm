import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x, cnt;

        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
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

        int ans = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.y == h - 1 && node.x == w - 1) {
                ans = visited[node.y][node.x][node.cnt];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                if (visited[ny][nx][node.cnt] != 0 || a[ny][nx] == 1) continue;
                q.add(new Node(ny, nx, node.cnt));
                visited[ny][nx][node.cnt] = visited[node.y][node.x][node.cnt] + 1;
            }

            if (node.cnt < k) {
                for (int i = 0; i < 8; i++) {
                    int ny = node.y + dyH[i];
                    int nx = node.x + dxH[i];
                    if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                    if (visited[ny][nx][node.cnt + 1] != 0 || a[ny][nx] == 1) continue;
                    q.add(new Node(ny, nx, node.cnt + 1));
                    visited[ny][nx][node.cnt + 1] = visited[node.y][node.x][node.cnt] + 1;
                }
            }
        }

        bw.write((ans - 1) + "");
        bw.flush();
    }
}