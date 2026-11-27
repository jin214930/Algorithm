import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] a;
    static boolean[][] visited;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for (int i = sy; i < ey; i++) {
                for (int j = sx; j < ex; j++) {
                    a[i][j] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && !visited[i][j]) {
                    list.add(dfs(i, j));
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for (int i : list) {
            bw.write(i + " ");
        }

        bw.flush();
    }

    static int dfs(int y, int x) {
        visited[y][x] = true;
        int ret = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if (a[ny][nx] == 1 || visited[ny][nx])
                continue;
            ret += dfs(ny, nx);
        }

        return ret;
    }
}
