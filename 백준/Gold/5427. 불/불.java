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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            Queue<Node> qF = new LinkedList<>();
            Queue<Node> qP = new LinkedList<>();
            int[][] fire = new int[h][w];
            int[][] visited = new int[h][w];
            char[][] a = new char[h][w];

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    a[i][j] = s.charAt(j);
                    if (a[i][j] == '@') {
                        qP.add(new Node(i, j));
                        visited[i][j] = 1;
                    } else if (a[i][j] == '*') {
                        qF.add(new Node(i, j));
                        fire[i][j] = 1;
                    }
                }
            }

            while (!qF.isEmpty()) {
                Node node = qF.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = node.y + dy[i];
                    int nx = node.x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= h || nx >= w || fire[ny][nx] != 0 || a[ny][nx] == '#') continue;
                    qF.add(new Node(ny, nx));
                    fire[ny][nx] = fire[node.y][node.x] + 1;
                }
            }

            int ans = -1;
            while (!qP.isEmpty()) {
                Node node = qP.poll();
                if (node.y == 0 || node.y == h - 1 || node.x == 0 || node.x == w - 1) {
                    ans = visited[node.y][node.x];
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = node.y + dy[i];
                    int nx = node.x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= h || nx >= w || visited[ny][nx] != 0 || a[ny][nx] == '#') continue;
                    if (fire[ny][nx] != 0 && visited[node.y][node.x] + 1 >= fire[ny][nx]) continue;
                    qP.add(new Node(ny, nx));
                    visited[ny][nx] = visited[node.y][node.x] + 1;
                }
            }

            if (ans == -1)
                bw.write("IMPOSSIBLE\n");
            else
                bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}