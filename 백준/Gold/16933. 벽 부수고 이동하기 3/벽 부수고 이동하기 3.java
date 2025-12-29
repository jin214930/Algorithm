import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static class Node {
        int y, x, cnt, d;

        Node(int y, int x, int cnt, int d) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                a[i][j] = s.charAt(j);
        }

        int[][][] visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visited[0][0][1] = 0;

        int ans = -1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.y == n - 1 && node.x == m - 1) {
                ans = node.d;
                break;
            }

            int day = node.d % 2;
            int nextDay = (node.d + 1) % 2;

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if (a[ny][nx] == '0') {
                    if (node.cnt < visited[ny][nx][nextDay]) {
                        visited[ny][nx][nextDay] = node.cnt;
                        q.add(new Node(ny, nx, node.cnt, node.d + 1));
                    }
                } else {
                    if (node.cnt >= k) continue;
                    if (day == 1) {
                        if (node.cnt + 1 < visited[ny][nx][nextDay]) {
                            visited[ny][nx][nextDay] = node.cnt + 1;
                            q.add(new Node(ny, nx, node.cnt + 1, node.d + 1));
                        }
                    } else {
                        if (node.cnt < visited[node.y][node.x][nextDay]) {
                            visited[node.y][node.x][nextDay] = node.cnt;
                            q.add(new Node(node.y, node.x, node.cnt, node.d + 1));
                        }
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}