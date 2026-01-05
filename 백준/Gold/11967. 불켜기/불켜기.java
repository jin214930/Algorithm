import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n + 1][n + 1];
        boolean[][] light = new boolean[n + 1][n + 1];

        List<Node>[][] adj = new List[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                adj[i][j] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            adj[y][x].add(new Node(b, a));
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1));
        visited[1][1] = true;
        light[1][1] = true;

        int ans = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();

            int y = node.y;
            int x = node.x;

            for (Node nd : adj[y][x]) {
                if (light[nd.y][nd.x]) continue;

                light[nd.y][nd.x] = true;
                ans++;

                for (int i = 0; i < 4; i++) {
                    int ny = nd.y + dy[i];
                    int nx = nd.x + dx[i];

                    if (ny < 1 || nx < 1 || ny > n || nx > n) continue;
                    if (visited[ny][nx]) {
                        q.add(nd);
                        visited[nd.y][nd.x] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny < 1 || nx < 1 || ny > n || nx > n || visited[ny][nx] || !light[ny][nx]) continue;

                q.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}