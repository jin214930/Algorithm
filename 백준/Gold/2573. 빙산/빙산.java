import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] a;
	static boolean[][] visited;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m)
				continue;
			if (visited[ny][nx] || a[ny][nx] == 0)
				continue;
			dfs(ny, nx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		while (true) {
			ans++;

			int tmp[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (a[i][j] > 0) {
						for (int k = 0; k < 4; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if (a[ny][nx] == 0)
								tmp[i][j]++;
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					a[i][j] = Math.max(0, a[i][j] - tmp[i][j]);
			}

			int cnt = 0;
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (a[i][j] > 0 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			if (cnt == 0) {
				bw.write("0");
				bw.flush();
				bw.close();
				return;
			} else if (cnt >= 2)
				break;
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}