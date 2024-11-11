import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] a;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] || a[ny][nx] == 1)
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
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					cnt += a[i][j];
			}

			if (cnt == 0)
				break;

			visited = new boolean[n][m];
			visited[0][0] = true;
			dfs(0, 0);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (a[i][j] == 1) {
						int tmp = 0;
						for (int k = 0; k < 4; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if (visited[ny][nx])
								tmp++;
						}
						if (tmp >= 2)
							a[i][j] = 0;
					}
				}
			}

			ans++;
		}

		bw.write(ans + "");

		bw.flush();
		bw.close();
	}
}
