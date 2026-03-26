import java.io.*;
import java.util.*;

public class Main {
	static int r, c, k, ans;
	static char[][] a;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new char[r][c];

		for (int i = 0; i < r; i++) {
			a[i] = br.readLine().toCharArray();
		}

		visited = new boolean[r][c];
		visited[r - 1][0] = true;
		dfs(r - 1, 0, 1);

		bw.write(ans + "");
		bw.flush();
	}

	static void dfs(int y, int x, int d) {
		if (d == k) {
			if (y == 0 && x == c - 1) {
				ans++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= r || nx >= c)
				continue;
			if (a[ny][nx] == 'T' || visited[ny][nx])
				continue;
			visited[ny][nx] = true;
			dfs(ny, nx, d + 1);
			visited[ny][nx] = false;
		}
	}
}
