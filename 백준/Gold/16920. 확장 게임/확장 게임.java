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

    static int n, m, p;
    static char[][] a;
    static int[] s;
    static int[] ans;
    static Queue<Node>[] queues;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static boolean bfs(int x) {
        Queue<Node> q = queues[x];
        if (q.isEmpty()) return false;
        boolean flag = false;

        int cnt = s[x];
        while (cnt-- > 0) {
            int size = q.size();
            if (size == 0)
                break;
            while (size-- > 0) {
                Node node = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = node.y + dy[i];
                    int nx = node.x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] != '.') continue;
                    a[ny][nx] = (char) (x + '0');
                    q.add(new Node(ny, nx));
                    ans[x]++;
                    flag = true;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        s = new int[p + 1];
        ans = new int[p + 1];
        queues = new LinkedList[p + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            queues[i] = new LinkedList<>();
        }

        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j);
                if (a[i][j] >= '1' && a[i][j] <= '9') {
                    queues[a[i][j] - '0'].add(new Node(i, j));
                    ans[a[i][j] - '0']++;
                }
            }
        }

        while (true) {
            boolean flag = false;
            for (int i = 1; i <= p; i++) {
                if (bfs(i))
                    flag = true;
            }

            if (!flag)
                break;
        }

        for (int i = 1; i <= p; i++)
            bw.write(ans[i] + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}