import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] a;
    static int cnt = 2;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void dfs(int y, int x) {
        int tmp = a[y][x];
        a[y][x] = cnt;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if (a[ny][nx] == tmp) {
                dfs(ny, nx);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 2; i <= cnt; i++) {
            Queue<Node> q = new LinkedList<>();
            int[][] visited = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (a[j][k] == i) {
                        q.add(new Node(j, k));
                        visited[j][k] = 1;
                    }
                }
            }

            while (!q.isEmpty()) {
                Node node = q.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = node.y + dy[j];
                    int nx = node.x + dx[j];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                    if (visited[ny][nx] != 0) continue;
                    if (a[ny][nx] == 0) {
                        q.add(new Node(ny, nx));
                        visited[ny][nx] = visited[node.y][node.x] + 1;
                    } else if (a[ny][nx] != i) {
                        ans = Math.min(ans, visited[node.y][node.x] - 1);
                        q.clear();
                        break;
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}