import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++)
            a[i] = br.readLine().toCharArray();

        int[][] visited = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == '0' || visited[ny][nx] != 0) continue;
                q.add(new Node(ny, nx));
                visited[ny][nx] = visited[node.y][node.x] + 1;
            }
        }

        bw.write(visited[n - 1][m - 1] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}