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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] a = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++)
                Arrays.fill(a[i], '.');

            for (int i = 1; i <= h; i++) {
                String s = br.readLine();
                for (int j = 1; j <= w; j++)
                    a[i][j] = s.charAt(j - 1);
            }

            boolean[] hasKey = new boolean[26];
            String s = br.readLine();
            if (!s.equals("0")) {
                for (char c : s.toCharArray())
                    hasKey[c - 'a'] = true;
            }

            int ans = 0;
            while (true) {
                Queue<Node> q = new LinkedList<>();
                boolean[][] visited = new boolean[h + 2][w + 2];
                q.add(new Node(0, 0));
                visited[0][0] = true;

                boolean flag = false;
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = node.y + dy[i];
                        int nx = node.x + dx[i];
                        if (ny < 0 || nx < 0 || ny > h + 1 || nx > w + 1) continue;
                        if (visited[ny][nx] || a[ny][nx] == '*') continue;
                        if (a[ny][nx] >= 'a' && a[ny][nx] <= 'z') {
                            hasKey[a[ny][nx] - 'a'] = true;
                            a[ny][nx] = '.';
                            flag = true;
                        } else if (a[ny][nx] >= 'A' && a[ny][nx] <= 'Z') {
                            if (!hasKey[a[ny][nx] - 'A']) continue;
                            a[ny][nx] = '.';
                        } else if (a[ny][nx] == '$') {
                            ans++;
                            a[ny][nx] = '.';
                        }
                        visited[ny][nx] = true;
                        q.add(new Node(ny, nx));
                    }
                }

                if (!flag) break;
            }

            bw.write(ans + "\n");
        }

        bw.flush();
    }
}