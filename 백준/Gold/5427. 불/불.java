import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            char[][] a = new char[n][m];

            Queue<Node> qF = new LinkedList<>();
            int[][] fire = new int[n][m];
            Queue<Node> qP = new LinkedList<>();
            int[][] people = new int[n][m];

            for (int i = 0; i < n; i++) {
                Arrays.fill(fire[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    a[i][j] = s.charAt(j);

                    if (a[i][j] == '*') {
                        qF.offer(new Node(i, j));
                        fire[i][j] = 1;
                    } else if (a[i][j] == '@') {
                        qP.offer(new Node(i, j));
                        people[i][j] = 1;
                    }
                }
            }

            while (!qF.isEmpty()) {
                Node cur = qF.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                        continue;
                    if (a[ny][nx] == '#' || fire[ny][nx] != Integer.MAX_VALUE)
                        continue;
                    qF.add(new Node(ny, nx));
                    fire[ny][nx] = fire[cur.y][cur.x] + 1;
                }
            }

            int ans = 0;
            while (!qP.isEmpty()) {
                Node cur = qP.poll();

                if (cur.y == 0 || cur.y == n - 1 || cur.x == 0 || cur.x == m - 1) {
                    ans = people[cur.y][cur.x];
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                        continue;
                    if (a[ny][nx] == '#' || people[ny][nx] != 0)
                        continue;
                    if (people[cur.y][cur.x] + 1 >= fire[ny][nx])
                        continue;

                    qP.offer(new Node(ny, nx));
                    people[ny][nx] = people[cur.y][cur.x] + 1;
                }
            }

            if (ans == 0) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(ans + "\n");
            }
        }

        bw.flush();
    }
}
