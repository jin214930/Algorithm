import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] a;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int dfs(int y, int x) {
        visited[y][x] = true;
        int ret = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == '0' || visited[ny][nx]) continue;
            ret += dfs(ny, nx);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        a = new char[n][n];
        for (int i = 0; i < n; i++)
            a[i] = br.readLine().toCharArray();


        visited = new boolean[n][n];
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == '1' && !visited[i][j]) {
                    list.add(dfs(i, j));
                    ans++;
                }
            }
        }

        Collections.sort(list);
        bw.write(ans + "\n");
        for (int i : list)
            bw.write(i + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}