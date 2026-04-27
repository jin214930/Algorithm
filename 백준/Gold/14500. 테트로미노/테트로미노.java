import java.io.*;
import java.util.*;

public class Main {
	static int n, m, ans;
	static int[][] a;
	static boolean visited[][];
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, a[i][j], 1);
				visited[i][j] = false;

				if (i - 1 >= 0 && i + 1 < n && j + 1 < m) {
					ans = Math.max(ans, a[i][j] + a[i - 1][j] + a[i + 1][j] + a[i][j + 1]);
				}
				if (i + 1 < n && j - 1 >= 0 && j + 1 < m) {
					ans = Math.max(ans, a[i][j] + a[i + 1][j] + a[i][j - 1] + a[i][j + 1]);
				}
				if (i - 1 >= 0 && j - 1 >= 0 && j + 1 < m) {
					ans = Math.max(ans, a[i][j] + a[i - 1][j] + a[i][j - 1] + a[i][j + 1]);
				}
				if (i - 1 >= 0 && i + 1 < n && j - 1 >= 0) {
					ans = Math.max(ans, a[i][j] + a[i - 1][j] + a[i + 1][j] + a[i][j - 1]);
				}
			}
		}

		bw.write(ans + "");
		bw.flush();
	}

	static void dfs(int y, int x, int sum, int depth) {
		if (depth == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= n || nx >= m || ny < 0 || nx < 0 || visited[ny][nx]) {
				continue;
			}

			visited[ny][nx] = true;
			dfs(ny, nx, sum + a[ny][nx], depth + 1);
			visited[ny][nx] = false;
		}
	}
}
